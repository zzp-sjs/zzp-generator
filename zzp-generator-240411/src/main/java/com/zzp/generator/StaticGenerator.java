package com.zzp.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *静态文件生成
 */


public class StaticGenerator {

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


    public static void main(String[] args) {
        // 获取整个项目的根路径
        String propertyPath = System.getProperty("user.dir");
        System.out.println(propertyPath);
        File parentFile = new File(propertyPath).getParentFile();
        // 输入路径：ACM 示例代码模板目录
        String inputPath = new File(parentFile,"zzp-generator-basic/acm-template").getAbsolutePath();
        System.out.println(inputPath);
        // 输出路径：直接输出到项目的根目录
        String outputPath = propertyPath;
        copyFilesByHutool(inputPath, outputPath);
    }

    /**
     * 拷贝文件（Hutool 实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outPutPath
     */
    public static void copyFilesByHutool(String inputPath,String outPutPath) {
        FileUtil.copy(inputPath,outPutPath,false);
    }

    /**
     * 递归拷贝文件（递归来实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outPutPath
     */
    public static void copyFilesByRecursive(String inputPath,String outPutPath){

        File inputFile = new File(inputPath);
        File outputFile = new File(outPutPath);
        try {
            copyFileByRecursive(inputFile,outputFile);
        }catch (Exception e){
            System.out.println("文件复制失败");
            e.printStackTrace();
        }
    }


    public static void copyFileByRecursive(File inputFile,File outputFile) throws IOException {
        //区分是目录还是文件
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile,inputFile.getName());
            //如果是目录就先创建目标目录
            if(!destOutputFile.exists()){
                destOutputFile.mkdirs();
            }
            //获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            //如果没有子文件，则退出
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            //for循环实现递归copy,并且-ls
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
                copyFileByRecursive(files[i], destOutputFile);
            }
            //增强for实现递归copy
//            for (File file : files) {
//                //递归循环下一层文件
//                copyFileByRecursive(file, destOutputFile);
//            }
        }else {
            //是文件直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }

    }

}
