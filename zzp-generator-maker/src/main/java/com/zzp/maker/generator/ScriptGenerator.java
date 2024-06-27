package com.zzp.maker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/06/24/下午2:11
 * @Description:
 */
public class ScriptGenerator {
    public static void doGenerator(String outPutPath, String jarPath) {
        //直接写入脚本文件
        //Linux
        StringBuffer sb = new StringBuffer();
        sb.append("#!/bin/bash").append("\n");
        sb.append(String.format("java -jar %s \"$@\"",jarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8), outPutPath);
        //添加可执行权限
        try {
            Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
            Files.setPosixFilePermissions(Paths.get(outPutPath),permissions);
        } catch (Exception e) {

        }

        //windows
        sb = new StringBuffer();
        sb.append("@echo off").append("\n");
        sb.append(String.format("java -jar %s %%*",jarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8), outPutPath + ".bat");
         }

    public static void main(String[] args) {
        String outPutPath = System.getProperty("user.dir") + File.separator + "generator";
        doGenerator(outPutPath, "");
    }
}
