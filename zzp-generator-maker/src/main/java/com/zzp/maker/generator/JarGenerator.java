package com.zzp.maker.generator;

import java.io.IOException;

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
        String mavenCommand = otherMavenCommand;
    }
}
