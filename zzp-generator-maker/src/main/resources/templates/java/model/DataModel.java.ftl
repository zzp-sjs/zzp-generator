package ${basePackage}.model;

import lombok.Data;

/**
 *数据模型
 */
@Data
public class DataModel {
<#list modelConfigDTO.modelConfig.model as modelInfo>
    <#if modelInfo.description??>
     /**
      *${modelInfo.description}
      */
    </#if>
    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defauleValue??> = ${modelInfo.defaultValue?c}</#if>
</#list>
}