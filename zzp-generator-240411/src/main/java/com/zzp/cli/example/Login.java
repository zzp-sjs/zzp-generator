package com.zzp.cli.example;

import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/上午11:14
 * @Description:
 */
public class Login implements Callable<Integer> {
    @CommandLine.Option(names = {"-u","--user"},description = "user name")
    String user;

    @CommandLine.Option(names = {"-p","--password"},arity = "0..1",description = "passphrase",interactive = true)
    String password;

    @CommandLine.Option(names = {"-cp","--checkPassword"},arity = "0..1",description = "Check Password",interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password" + password);
        System.out.println("checkPassword" + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u","user123","-p","password123","-cp","456");
//        new CommandLine(new Login()).execute();
    }
}
