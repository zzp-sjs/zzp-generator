package com.zzp.generator;
import com.zzp.model.MainTemplateConfig;
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

/**
 * 核心生成器
 */
public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
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


    String inputRootPath = "C:\\Users\\26648\\Desktop\\马到成功\\坚持不懈\\zzp-generator\\zzp-generator-demo-projects\\acm-template-pro";
    String outputRootPath = "C:\\Users\\26648\\Desktop\\马到成功\\坚持不懈\\zzp-generator\\acm-template-pro";

    String inputPath;
    String outputPath;

    inputPath = new File(inputRootPath, "src/main/java/com/zzp/acm/MainTemplate.java.ftl").getAbsolutePath();
    outputPath = new File(outputRootPath, "src/main/java/com/zzp/acm/MainTemplate.java").getAbsolutePath();
    DynamicGenerator.doGenerate(inputPath, outputPath, model);

    inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
    outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
    StaticGenerator.copyFilesByHutool(inputPath, outputPath);

    inputPath = new File(inputRootPath, "READE.md").getAbsolutePath();
    outputPath = new File(outputRootPath, "READE.md").getAbsolutePath();
    StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zzp");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果:");
        doGenerate(mainTemplateConfig);
    }
}
