package com.zzp.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.zzp.maker.generator.file.DynamicFileGenerator;
import com.zzp.maker.meta.Meta;
import com.zzp.maker.meta.MetaManger;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/22/上午9:54
 * @Description:
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {

        Meta meta = MetaManger.getMetaObject();
        System.out.println(meta);

        // 输出根路径
        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generated" + File.separator + meta.getName();
        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }
        // 读取输入路径
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();

        // Java 包基础路径
        // com.zzp
        String outoutBasePackage = meta.getBasePackage();
        // com/zzp
        String outputBasePackagePath = StrUtil.join("/",StrUtil.split(outoutBasePackage,"."));
        // generated/src/main/java/com/zzp
        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java" + outputBasePackagePath;

        String inputFilePath;
        String outputFilePath;

        inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "model" + File.separator + "DataModel.java.ftl";
        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);


    }
}
