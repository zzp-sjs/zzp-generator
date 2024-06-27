package com.zzp.maker.generator;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/06/11/下午12:39
 * @Description:
 */
public class JarGenerator {
    public static void doGenerator(String projectDir) throws IOException, InterruptedException {
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = winMavenCommand;

        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) !=null) {
            System.out.println(line);
        }
        int exitCode = process.waitFor();
        System.out.println("命令执行结束。你要退出吗：" + exitCode);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerator("C:\\Users\\26648\\Desktop\\马到成功\\坚持不懈\\zzp-generator\\zzp-generator-basic");
    }
}
