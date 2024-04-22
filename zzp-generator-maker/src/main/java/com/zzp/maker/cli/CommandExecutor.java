package com.zzp.maker.cli;

import com.zzp.maker.cli.command.ConfigCommand;
import com.zzp.maker.cli.command.GenerateCommand;
import com.zzp.maker.cli.command.ListCommand;
import picocli.CommandLine;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午4:31
 * @Description:
 */

@CommandLine.Command(name = "zzp",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private static CommandLine commandLine;

    {
        commandLine  = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());


    }
    @Override
    public void run() {
        //不输入子命令时，给出友好提示
        System.out.println("请输入具体命令,或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public  Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
