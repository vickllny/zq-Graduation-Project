package ${package}.entity.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import ${package}.entity.${entityClass};

/**
 * 描述: ${logicName}vo
 * Time: ${time}
 * @author: ${author}
 * @version 1.0
 */
public class ${entityClass}Vo{
	<#list columns as list>
	/**
	 * ${list.logicName}
	 */
			<#if list.javaType == 'Date'>
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private ${list.javaType} ${list.fieldName};
			<#else>
	private ${list.javaType} ${list.fieldName};
			</#if>
	</#list>

	<#list voFields as list>
	/**
	 * ${list.comment}
	 */
	private ${list.type} ${list.field};
	</#list>
	
	public static ${entityClass}Vo build(${entityClass} ${simpleName}<#list voFields as list>,${list.type} ${list.field}</#list>){
		${entityClass}Vo vo = new ${entityClass}Vo();
		BeanUtils.copyProperties(${simpleName}, vo);
		<#list voFields as list>
		vo.${list.field} = ${list.field};
		</#list>
		return vo;
	}
	
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
	<#list voFields as list>
	/**
	 * 获取${list.comment}
	 */
	public ${list.type} get${list.field?cap_first}(){
		return ${list.field};
	}
	/**
	* 设置${list.comment}
	* @param ${list.field} ${list.comment}
	*/
	public void set${list.field?cap_first}(${list.type} ${list.field}){
		this.${list.field}=${list.field};
	}
	</#list>
}