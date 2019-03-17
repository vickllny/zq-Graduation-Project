package com.zq.codegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ResourceUtils;

/**
 * 所属类别: 工具类<br/> 用途: 为代码生成器获取数据库信息<br/> Author:<a
 * href="mailto:hxfein@126.com">黄飞</a> <br/> Date: 2011-6-17 <br/> Time:
 * 下午02:31:40 <br/> Version: 1.0.2 <br/>
 */
public class DBAccess {
	private static Log log = LogFactory.getLog(DBAccess.class);
	/**
	 * 连接信息
	 */
	private Properties properties = new Properties();
	/**
	 * 类型映射
	 */
	private Properties mappings = new Properties();
	/**
	 * 连接
	 */
	private Connection conn;
	/**
	 * 数据库类型--这里默认为postgresql
	 */
	private String dbType = DB_TYPE_MYSQL;
	
	/**
	 * 数据库类型oracle
	 */
	private static final String DB_TYPE_ORACLE = "oracle";
	/**
	 * 数据库类型postgresql
	 */
	private static final String DB_TYPE_POSTGRE = "postgresql";
	/**
	 * 数据库类型mysql
	 */
	private static final String DB_TYPE_MYSQL = "mysql";
	
	public DBAccess(String configFile) {
		try {
			File file = ResourceUtils
					.getFile(configFile);
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
			if(StringUtils.isNotBlank(properties.getProperty("jdbc.dbtype"))) {
				dbType = properties.getProperty("jdbc.dbtype");
			}
			System.out.println("数据库类型："+dbType);
			fis.close();
			InputStream ins = getClass().getResourceAsStream(
					"mapping.properties");
			mappings.load(ins);
			System.out.println(mappings);
			ins.close();
		} catch (Exception er) {
			throw new RuntimeException(er);
		}
	}
	
	/**
	 * 查询表信息
	 * 
	 * @param table
	 */
	public void queryTable(Table table) {
		List<Column> columns = table.getColumns();
		Map<String, String> comments = this.getComments(table);
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(table.getQuerySql());
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			String fieldNames[] = new String[columnCount];
			for (int i = 0; i < columnCount; i++) {
				String dbColName = meta.getColumnName(i + 1);
				Column column = new Column();
				if (i == 0) {
					column.setPk(true);
					table.setPkColumn(column);
				} else {
					column.setPk(false);
				}

				column.setDbName(dbColName);
				String columnType = meta.getColumnTypeName(i + 1).toUpperCase();
				column.setDbType(columnType);
				String fieldName = this.getFieldName(table, dbColName);
				column.setFieldName(fieldName);
				String javaType = mappings.getProperty(columnType);
				column.setJavaType(javaType);
				System.out.println(dbColName +"	dbType:" + columnType + "    javaType:"
						+ javaType);
				int length = meta.getPrecision(i + 1);
				column.setLength(length);
				String comment = comments.get(dbColName.toLowerCase());
				String logicName = comment == null ? dbColName : comment;
				column.setLogicName(logicName);
				int nullable = meta.isNullable(i + 1);
				column.setNullable(nullable == ResultSetMetaData.columnNullable
						|| nullable == ResultSetMetaData.columnNullableUnknown);
				columns.add(column);
				fieldNames[i] = column.getFieldName();
			}
			table.setComments(comments);
			table.setListNames(fieldNames);
			closeObject(rs);
			closeObject(stmt);
		} catch (Exception er) {
			throw new RuntimeException(er);
		} finally {
			close();
		}
	}

	public Connection open() {
		if (conn == null) {
			try {
				Class.forName(properties.getProperty("jdbc.driver"));
				conn = DriverManager.getConnection(properties
						.getProperty("jdbc.url"), properties
						.getProperty("jdbc.username"), properties
						.getProperty("jdbc.password"));
			} catch (Exception er) {
				throw new RuntimeException(er);
			}
		}
		return conn;
	}

	public void close() {
		closeObject(conn);
		conn = null;
	}

	public void closeObject(Object o) {
		if (o != null) {
			try {
				Method method = o.getClass().getMethod("close");
				method.invoke(o);
			} catch (Exception er) {
				log.debug(er.getMessage());
			}
		}
	}

	/**
	 * 获取字段注释
	 * 
	 * @param table
	 * @return
	 */
	private Map<String, String> getComments(Table table) {
		Map<String, String> map = new HashMap<String, String>();
		String tableName = table.getDbName();
		try {
			String sql = "";
			if(DB_TYPE_POSTGRE.equals(dbType)) {
				sql = "select a.attname as name,col_description(a.attrelid,a.attnum) as comment from pg_class as c,pg_attribute as a where c.relname = '%s' and a.attrelid = c.oid and a.attnum>0";
			}
			else if(DB_TYPE_ORACLE.equals(dbType)) {
				sql = "SELECT" + 
						"	B.COLUMN_NAME COLUMN_NAME," + 
						"	A.COMMENTS COMMENTS " + 
						"FROM" + 
						"	USER_COL_COMMENTS A," + 
						"	ALL_TAB_COLUMNS B " + 
						"WHERE" + 
						"	A.TABLE_NAME = B.TABLE_NAME " + 
						"	AND a.column_name = b.COLUMN_NAME " + 
						"	AND A.TABLE_NAME = '%s'" + 
						"AND a.column_name = b.COLUMN_NAME";
				tableName = StringUtils.upperCase(tableName);
			}else if(DB_TYPE_MYSQL.equals(dbType)) {
				sql = "Select COLUMN_NAME name, COLUMN_COMMENT comment from INFORMATION_SCHEMA.COLUMNS Where table_name = '%s'";
			}
			sql=String.format(sql, tableName);
			Connection conn = open();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				map.put(rs.getString(1).toLowerCase(), rs.getString(2));
			}
			rs.close();
			stmt.close();
		} catch (Exception er) {
			er.printStackTrace();
			System.out.println("因数据读取错误，当前任务不能生成注释，但不影响代码生成。");
		} finally {
			close();
		}
		return map;
	}

	private String getFieldName(Table table, String s) {
		if(table.isConvertName()==false){
			return s;
		}
		char[] array = s.toCharArray();
		int len = array.length;
		boolean flag = true;
		int index = 0;
		char result[] = new char[len];
		for (int i = 0; i < len; i++) {
			if (array[i] == '_') {
				flag = true;
				continue;
			} else {
				char c = array[i];
				if (flag) {
					if (c <= 122 && c >= 97) {
						c = (char) (array[i] - 32);
					}
				} else {
					c = (char) (c | 32);
				}
				if (index == 0) {
					c = (char) (c | 32);
				}
				result[index++] = c;
				flag = false;
			}
		}
		return new String(result, 0, index);
	}

}
