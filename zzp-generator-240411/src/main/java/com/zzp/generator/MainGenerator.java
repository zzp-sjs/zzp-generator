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
        String projectDir = System.getProperty("user.dir");
        //整个目录的根路径
        File parentFile = new File(projectDir);
        System.out.println("整个目录的根路径");
        System.out.println(parentFile);
        //输入路径
        String inputPath = new File(parentFile, "zzp-generator-basic/acm-template").getAbsolutePath();
        System.out.println("静态文件输入路径"+inputPath);
        String outputPath = projectDir;
        System.out.println("静态文件输出路径"+outputPath);
        //生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
        //生成动态文件
        String inputDynamicFilePath = projectDir+File.separator+"zzp-generator-240411/src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath+File.separator+"zzp-generator-240411/acm-template/src/com/zzp/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        doGenerate(mainTemplateConfig);
    }
}
