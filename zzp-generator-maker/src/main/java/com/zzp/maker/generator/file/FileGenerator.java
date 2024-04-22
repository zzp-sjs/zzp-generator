package com.zzp.maker.generator.file;
import com.zzp.maker.model.DataModel;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/17/上午10:51
 * @Description:
 */

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class FileGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectDir = System.getProperty("user.dir");
        //整个目录的根路径
          //解决jar包目录的根路径的问题
//        File parentFile = new File(projectDir).getParentFile();

        File parentFile = new File(projectDir);
        System.out.println("整个目录的根路径");
        System.out.println(parentFile);
        //输入路径
        String inputPath = new File(parentFile, "zzp-generator-basic/acm-template").getAbsolutePath();
        System.out.println("静态文件输入路径"+inputPath);
        String outputPath = projectDir;
        System.out.println("静态文件输出路径"+outputPath);
        //生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        //生成动态文件
          //解决jar包目录的根路径的问题
//        String inputDynamicFilePath = projectDir+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
//        System.out.println("动态文件输入路径"+inputDynamicFilePath);
//        String outputDynamicFilePath = outputPath+File.separator+"acm-template/src/com/zzp/acm/MainTemplate.java";
//        System.out.println("动态文件输出路径"+outputDynamicFilePath);

        String inputDynamicFilePath = projectDir+File.separator+"zzp-generator-maker/src/main/resources/templates/MainTemplate.java.ftl";
        System.out.println("动态文件输入路径"+inputDynamicFilePath);
        String outputDynamicFilePath = outputPath+File.separator+"zzp-generator-maker/acm-template/src/com/zzp/acm/MainTemplate.java";
        System.out.println("动态文件输出路径"+outputDynamicFilePath);
        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        dataModel.setLoop(false);
        doGenerate(dataModel);
    }
}
