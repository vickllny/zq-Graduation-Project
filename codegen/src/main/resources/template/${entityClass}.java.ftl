package ${package}.entity;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 描述: ${logicName}实体类
 * Time: ${time}
 * @author: ${author}
 * @version 1.0
 */
@Entity
@Table(name="${dbName}")
public class ${entityClass}{
	<#list columns as list>
	/**
	 * ${list.logicName}
	 */
		<#if list.pk>
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private ${list.javaType} ${list.fieldName};
		<#else>
			<#if list.javaType == 'Date'>
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="${list.dbName}",length = ${list.length}, nullable = ${list.nullable?string})
	private ${list.javaType} ${list.fieldName};
			<#else>
	@Column(name="${list.dbName}",length = ${list.length}, nullable = ${list.nullable?string})
	private ${list.javaType} ${list.fieldName};
			</#if>
		</#if>
	</#list>
	
	<#list columns as list>
	/**
	 * 获取${list.logicName}
	 */
	public ${list.javaType} get${list.capitalizeName}(){
		return ${list.fieldName};
	}
	/**
	* 设置${list.logicName}
	* @param ${list.fieldName} ${list.logicName}
	*/
	public void set${list.capitalizeName}(${list.javaType} ${list.fieldName}){
		this.${list.fieldName}=${list.fieldName};
	}
	</#list>
}