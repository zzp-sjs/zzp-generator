package com.zzp.cli.example;

import picocli.CommandLine;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/17/下午4:59
 * @Description:
 */

@CommandLine.Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {
    @CommandLine.Option(names = {"-s","--font-size"}, description = "Font size")
    int fontSize = 19;

    @CommandLine.Parameters(paramLabel = "<word>", defaultValue = "Hello picocli",
                            description = "Words to be translated into ASCII art")
    private String[] word = {"Hello", "picocli"};
    @Override
    public void run() {
        //实现自己的业务
        System.out.println("font size: " + fontSize);
        System.out.println("word = " + String.join("，", word));
    }
    public static void main(String[] args) {
        int execute = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(execute);
    }
}
