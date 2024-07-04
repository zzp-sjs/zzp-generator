package com.zzp.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.zzp.maker.generator.JarGenerator;
import com.zzp.maker.generator.ScriptGenerator;
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
public class MainGenerator extends GenerateTemplate{

//    @Override
//    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputPath) {
//        System.out.println("不要输出dist了");
//    }

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}
