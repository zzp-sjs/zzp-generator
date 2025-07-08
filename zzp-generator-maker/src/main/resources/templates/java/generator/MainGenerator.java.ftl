package ${basePackage}.generator;

import ${basePackage}.model.DataModel;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/17/上午10:51
 * @Description:
 */

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

<#macro generateFile indent fileInfo>
${indent}inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
${indent}outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
<#if fileInfo.generateType == "static">
${indent}StaticGenerator.copyFilesByHutool(inputPath, outputPath);
<#else>
${indent}DynamicGenerator.doGenerate(inputPath, outputPath, model);
</#if>
</#macro>

/**
 * 核心生成器
 */
public class MainGenerator {

    public static void doGenerate(DataModel model) throws TemplateException, IOException {
//        String projectDir = System.getProperty("user.dir");
//        //整个目录的根路径
//          //解决jar包目录的根路径的问题
////        File parentFile = new File(projectDir).getParentFile();
//
//        File parentFile = new File(projectDir);
//        System.out.println("整个目录的根路径");
//        System.out.println(parentFile);
//        //输入路径
//        String inputPath = new File(parentFile, "zzp-generator-basic/acm-template").getAbsolutePath();
//        System.out.println("静态文件输入路径"+inputPath);
//        String outputPath = projectDir;
//        System.out.println("静态文件输出路径"+outputPath);
//        //生成静态文件
//        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
//        //生成动态文件
//          //解决jar包目录的根路径的问题
////        String inputDynamicFilePath = projectDir+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
////        System.out.println("动态文件输入路径"+inputDynamicFilePath);
////        String outputDynamicFilePath = outputPath+File.separator+"acm-template/src/com/zzp/acm/MainTemplate.java";
////        System.out.println("动态文件输出路径"+outputDynamicFilePath);
//
//        String inputDynamicFilePath = projectDir+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
//        System.out.println("动态文件输入路径"+inputDynamicFilePath);
//        String outputDynamicFilePath = outputPath+File.separator+"acm-template/src/com/zzp/acm/MainTemplate.java";
//        System.out.println("动态文件输出路径"+outputDynamicFilePath);
//        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
//    }
//
//    public static void main(String[] args) throws TemplateException, IOException {
//        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
//        mainTemplateConfig.setLoop(false);
//        doGenerate(mainTemplateConfig);


    String inputRootPath = "${fileConfig.inputRootPath}";
    String outputRootPath = "${fileConfig.outputRootPath}";

    String inputPath;
    String outputPath;

    <#-- 获取模型变量 -->
    <#list modelConfig.models as modelInfo>
    <#-- 有分组 -->
    <#if modelInfo.groupKey??>
    <#list modelInfo.models as subModelInfo>
    ${subModelInfo.type} ${subModelInfo.fieldName} = model.${modelInfo.groupKey}.${subModelInfo.fieldName};
    </#list>
    <#else>
    ${modelInfo.type} ${modelInfo.fieldName} = model.${modelInfo.fieldName};
    </#if>
    </#list>

<#list fileConfig.files as fileInfo>
    <#if fileInfo.groupKey??>
    //groupKey = ${fileInfo.groupKey}
    <#if fileInfo.condition??>
    if(${fileInfo.condition}) {
    <#list fileInfo.files as fileInfo>
    <@generateFile fileInfo=fileInfo indent="            "/>
    </#list>
    }
    <#else>
    <#list fileInfo.files as fileInfo>
    <@generateFile fileInfo=fileInfo indent="        "/>
    </#list>
    </#if>
    <#else>
    <#if fileInfo.condition??>
    if(${fileInfo.condition}) {
        <@generateFile fileInfo=fileInfo indent="            "/>
    }
    <#else>
    <@generateFile fileInfo=fileInfo indent="        "/>
    </#if>
    </#if>

</#list>

<#--    inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();-->
<#--    outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();-->
<#--    StaticGenerator.copyFilesByHutool(inputPath, outputPath);-->

<#--    inputPath = new File(inputRootPath, "READE.md").getAbsolutePath();-->
<#--    outputPath = new File(outputRootPath, "READE.md").getAbsolutePath();-->
<#--    StaticGenerator.copyFilesByHutool(inputPath, outputPath);-->
    }


}
