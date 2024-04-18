package com.zzp.cli.example;

import org.apache.commons.collections4.sequence.DeleteCommand;
import picocli.CommandLine;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午1:53
 * @Description:
 */

@CommandLine.Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {
    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @CommandLine.Command(name = "add", description = "增加", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        public void run() {
            System.out.println("执行增加命令");
        }
    }

    @CommandLine.Command(name = "delete", description = "删除", mixinStandardHelpOptions = true)
static class DeleteCommand implements Runnable {
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    @CommandLine.Command(name = "query", description = "查询", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable {
        public void run() {
            System.out.println("执行查询命令");
        }
    }

    public static void main(String[] args) {
        //执行主程序
        String[] myArgs = new String[] {"--help"};

        int exitCode = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);
        System.exit(exitCode);
    }

}
//抽象类实现接口
//abstract class zzp implements zzp946{
//    public void zzp(){
//        System.out.println("zzp946");
//    }
//}
//
//interface zzp946 {
//    void zzp();
//}
