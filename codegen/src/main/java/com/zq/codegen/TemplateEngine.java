package com.zq.codegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

/**
 * 所属类别: 工具类<br/> 用途: 将表信息输出到模板<br/> Author:<a
 * href="mailto:hxfein@126.com">黄飞</a> <br/> Date: 2011-6-17 <br/> Time:
 * 下午03:26:35 <br/> Version: 1.0.2 <br/>
 */
public class TemplateEngine {
	private Log log = LogFactory.getLog(TemplateEngine.class);
	private Configuration configuration = null;
	private File directory;
	private File outputDir;

	public TemplateEngine(File templateDir, File outputDir) {
		try {
			directory = templateDir;
			this.outputDir = outputDir;
			configuration = new Configuration(new Version(2, 3, 21));
			configuration.setEncoding(Locale.CHINA,"utf-8");
			configuration.setOutputEncoding("utf-8");
			configuration.setNumberFormat("#");
			configuration.setTemplateUpdateDelayMilliseconds(1);
			configuration.setDirectoryForTemplateLoading(directory);
		} catch (Exception er) {
			log.error("错误", er);
		}
	}

	public void doWork(Table table) throws Exception {
		if(StringUtils.isBlank(table.getModuleName())) {
			throw new RuntimeException("必须设置moduleName");
		}
		String[] files = directory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.equals(".svn")) {
					return false;
				}
				return true;
			}
		});
		for (int i = 0; i < files.length; i++) {
			File file = new File(files[i]);
			String fileName = file.getName();
			//如果不是树类型，过滤树模版的数据填充
			if(!table.isTreeList()) {
				if(fileName.equals("treeList.ftl.ftl")) {
					continue;
				}
			}
			String targetName = fileName;
			if(targetName.contains("{entityClass}")) {
				targetName  = targetName.replace("${entityClass}", table.getEntityClass());
			}
			if(targetName.contains("{action}")) {
				targetName  = targetName.replace("${action}", table.getAction());
			}
			targetName  = targetName.replaceFirst("\\.ftl", "");
			outputDir.mkdirs();
			File targetFile = new File(outputDir.getAbsolutePath() + "/"
					+ targetName);
			Template ftlTemp = configuration.getTemplate(fileName, "utf-8");
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile),"utf-8"));
			ftlTemp.process(table, writer);
			writer.close();
		}
	}
}
