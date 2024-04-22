package com.zzp.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 *静态文件生成
 */


public class StaticFileGenerator {

//    public static void main(String[] args) {
//        String propertyPath = System.getProperty("user.dir");
//        System.out.println(propertyPath);
//        //输入路径
//        String inputPath = propertyPath+File.separator+"zzp-generator-basic"+ File.separator+"acm-template";
//        System.out.println(inputPath);
//        //输出路径
//        String outputPath = propertyPath;
////        //Hutool中的FileUtil.copy实现
////        copyFilesByHutool(inputPath, outputPath);
////        //Java中的Files.copy()实现
////        copyFilesByRecursive(inputPath, outputPath);
//    }



    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outPutPath
     */
    public static void copyFilesByHutool(String inputPath,String outPutPath) {
        FileUtil.copy(inputPath,outPutPath,false);
    }


}
