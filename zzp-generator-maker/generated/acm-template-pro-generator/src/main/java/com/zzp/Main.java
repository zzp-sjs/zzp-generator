package com.zzp;

import com.zzp.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        for (int i = 0; i < 3; i++) {
            System.out.println("zzp946");
        }

//        args =new String[]{"generate", "-l", "-generateCommand.java.ftl", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}