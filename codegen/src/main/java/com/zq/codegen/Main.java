package com.zq.codegen;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.util.ResourceUtils;

/**
 * 所属类别: 工具类<br/> 
 * 用途: 代码生成器入口<br/> 
 * Author:<a href="mailto:hxfein@126.com">黄飞</a> <br/> 
 * Date: 2011-6-17 <br/> 
 * Time: 下午03:19:45 <br/> 
 * Version: 1.0.2 <br/>
 */
public class Main {
	/**
	 * 工程地址
	 */
	private static final String PROJECT_DIR="/Users/wisesoft/vickllny/javadev/workspace/ws8/out";
	/**
	 * 输出地址
	 */
	private static final String OUTPUT_DIR="C:\\Users\\admin\\Desktop\\she";
	/**
	 * 模板地址
	 */
	private static final String TEMPLATE_DIR="classpath:template";
	
	public static void main(String[] args) throws Exception{
		DBAccess dba=new DBAccess("classpath:properties/mysql.properties");
		
		Table table=new Table();
		//工程地质
		table.setProjectDir(PROJECT_DIR);
		//生成的java文件的报名
		table.setPackage("com.zq.vm");
		//表名,和数据库大小写一致，否则不能查询到注释
		String tableName = "customer_set_meal_production";
		//实体类名
		table.setEntityClass("CustomerSetMealProduction");
		//模块名称,对应requestMapping的值
		table.setModuleName("customerSetMealProduction");
		//作者
		table.setAuthor("zou.qian");
		
		table.setDbName(tableName);
		table.setQuerySql("select * from "+tableName);
		table.setTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		table.setConvertName(true);
		table.setAction(null);// 子模块
		dba.queryTable(table);
		//实体类中文名
		table.setLogicName("会员套餐商品关系表");
		table.addVoField("String", "customerName", "会员名称").addVoField("String", "setMealName", "套餐名称").addVoField("String", "productName", "商品名称");
		File templateFolder=ResourceUtils.getFile(TEMPLATE_DIR);
		File outputDir=new File(OUTPUT_DIR);
		TemplateEngine engine=new TemplateEngine(templateFolder,outputDir);
		engine.doWork(table);
		System.out.println(table.getComments());
		System.out.println("生成成功，代码生成在: "+OUTPUT_DIR);
	}
}
