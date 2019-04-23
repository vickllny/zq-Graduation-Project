package com.zq.codegen;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 所属类别: 实体类<br/> 用途: 表信息<br/> Author:<a href="mailto:hxfein@126.com">黄飞</a>
 * <br/> Date: 2011-6-17 <br/> Time: 下午03:08:33 <br/> Version: 1.0.2 <br/>
 */
public class Table {
	/**
	 * 英文表名
	 */
	private String dbName;
	/**
	 * 中文表名
	 */
	private String logicName;
	/**
	 * 实体类名
	 */
	private String entityClass;
	/**
	 * 包名
	 */
	private String _package;
	/**
	 * 查询SQL
	 */
	private String querySql;
	/**
	 * 字段
	 */
	private List<Column> columns = new ArrayList<Column>();
	/**
	 * 工程路径
	 */
	private String projectDir;
	/**
	 * 主键列
	 */
	private Column pkColumn;
	/**
	 * 列表显示列
	 */
	private String[] listNames;
	/**
	 * 查询条件
	 */
	private String[] searchKeys;
	/**
	 * 查询条件名称
	 */
	private String[] searchKeysNames;
	/**
	 * 子表
	 */
	private Table[] children;
	/**
	 * 是否转换名称
	 */
	private boolean convertName = true;
	/**
	 * 模块名称
	 */
	private String moduleName;
	
	private String action = null;
	/**
	 * 注释
	 */
	private Map<String,String> comments= new HashMap<>();
	/**
	 * 时间
	 */
	private String time;
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 排序字段
	 */
	private String sort;
	/**
	 * 排序字段名称
	 */
	private String sortName;
	/**
	 * 查询字段
	 */
	private String searchKey;
	/**
	 * 列名
	 */
	private String[] listColumnNames;
	/**
	 * 服务名称
	 */
	private String serviceName;
	/**
	 * 是否使用树表结构
	 */
	private boolean treeList;
	/**
	 * 数据字典树编码
	 */
	private String treeDicCode;
	/**
	 * 树
	 */
	private Tree tree = new Tree();
	/**
	 * vo除了实体之外额外的字段
	 */
	private List<VoField> voFields = new ArrayList<>();
	
	
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public boolean isConvertName() {
		return convertName;
	}

	public void setConvertName(boolean convertName) {
		this.convertName = convertName;
	}

	public Table[] getChildren() {
		return children;
	}

	public void setChildren(Table[] children) {
		this.children = children;
	}

	public String[] getSearchKeys() {
		return searchKeys;
	}

	public void setSearchKeys(String[] searchKeys) {
		this.searchKeys = searchKeys;
	}

	public void setSearchKeys(String searchKeys){
		this.searchKeys=StringUtils.split(searchKeys,",");
	}
	public String getProjectDir() {
		return projectDir;
	}

	public void setProjectDir(String projectDir) {
		String path = FilenameUtils.separatorsToSystem(projectDir);
		this.projectDir = path;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getLogicName() {
		return logicName;
	}

	public void setLogicName(String logicName) {
		this.logicName = logicName;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public Map<String, String> getComments() {
		return comments;
	}

	public void setComments(Map<String, String> comments) {
		this.comments = comments;
	}

	public String getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}

	public String getPackage() {
		return _package;
	}

	public void setPackage(String _package) {
		this._package = _package;
	}

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}

	/**
	 * 获取简写名称
	 * 
	 * @return
	 */
	public String getSimpleName() {
		char array[] = this.entityClass.toCharArray();
		array[0] = (char) ((array[0]) | 32);
		return new String(array);
	}

	/**
	 * 获取名称
	 * 
	 * @return
	 */
	public String getAction() {
		if(StringUtils.isNotBlank(action)){
			return action;
		}
		return null;
	}
	/**
	 * 将包名转换为路径名
	 * @return
	 */
	public String getPackageDir() {
		String s = this.getPackage();
		if (s == null) {
			return "";
		}
		s = FilenameUtils.separatorsToSystem(s.replaceAll("\\.", "/"));
		return s;
	}
	/**
	 * 获取action的路径
	 * @return
	 */
	public String getActionPackageDir(){
		String s = this.getPackage();
		if (s == null) {
			return "";
		}
		String array[]=s.split("\\.");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<array.length;i++){
			sb.append(array[i]).append(File.separator);
			if(i==1){
				sb.append("action").append(File.separator);
			}
		}
		int len=sb.length();
		sb.deleteCharAt(len-1);
		return sb.toString();
	}
	/**
	 * 获取FTL文件夹的包名
	 * @return
	 */
	public String getFtlDir(){
		String s = this.getPackage();
		if (s == null) {
			return "";
		}
		String array[]=s.split("\\.");
		return array[array.length-1];
	}
	/**
	 * 获取action的包名
	 * @return
	 */
	public String getActionPackage(){
		String s = this.getPackage();
		if (s == null) {
			return "";
		}
		String array[]=s.split("\\.");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<array.length;i++){
			sb.append(array[i]).append(".");
			if(i==1){
				sb.append("action").append(".");
			}
		}
		int len=sb.length();
		sb.deleteCharAt(len-1);
		return sb.toString();
	}
//	
//	public static void main(String[] args) {
//		Table table = new Table();
//		table.entityClass = "com.wisesoft.sys";
//		System.out.println(table.entityClass.replaceAll("\\.", "/"));
//		System.out.println(table.entityClass);
//	}

	public Column getPkColumn() {
		return pkColumn;
	}

	public void setPkColumn(Column pkColumn) {
		this.pkColumn = pkColumn;
	}

	public String[] getListNames() {
		return listNames;
	}

	public void setListNames(String[] listNames) {
		this.listNames = listNames;
	}
	public void setListNames(String string){
		this.listNames=string.split(",");
	}
	
	public String[] getListColumnNames() {
		return listColumnNames;
	}

	public void setListColumnNames(String[] listColumnNames) {
		this.listColumnNames = listColumnNames;
	}
	public void setListColumnNames(String string){
		this.listColumnNames=string.split(",");
	}
	/**
	 * 获取所有列列名的字符串
	 * @return
	 */
	public String getColumnString(){
		StringBuilder sb=new StringBuilder();
		for(Column c:columns){
			sb.append(c.getFieldName()).append(",");
		}
		return sb.toString();
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 获取time
	 * @return time time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 设置time
	 * @param time time 
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * 获取author
	 * @return author author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 设置author
	 * @param author author 
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * spring cloud 服务名称
	 * @param serviceName
	 * Date: 2018年5月9日
	 * Time: 下午8:39:32
	 * @author li.lin
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String[] getSearchKeysNames() {
		return searchKeysNames;
	}
	

	public void setSearchKeysNames(String[] searchKeysNames) {
		this.searchKeysNames = searchKeysNames;
	}

	public String getSortName() {
		return sortName;
	}
	
	/**
	 * 设置排序字段名称
	 * @param sortName
	 * Date: 2018年5月10日
	 * Time: 下午5:17:26
	 * @author li.lin
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public boolean isTreeList() {
		return treeList;
	}
	

	public void setTreeList(boolean treeList) {
		this.treeList = treeList;
	}
	

	public Tree getTree() {
		return tree;
	}
	

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public String getTreeDicCode() {
		return treeDicCode;
	}

	public void setTreeDicCode(String treeDicCode) {
		this.treeDicCode = treeDicCode;
	}

	public List<VoField> getVoFields() {
		return voFields;
	}

	public void setVoFields(List<VoField> voFields) {
		this.voFields = voFields;
	}
	
	public Table addVoField(String type,String field,String comment) {
		this.voFields.add(new VoField(type, field, comment));
		return this;
	}

}
