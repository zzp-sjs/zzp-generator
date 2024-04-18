package com.zzp.cli.pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午4:02
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        //创建接收对象
        Device tv = new Device("TV");
        Device stereo = new Device("Stereo");

        //创建具体命令对象，可以绑定不同设备
        TurnOnCommand turnon = new TurnOnCommand(tv);
        TurnOffCommand turnoff = new TurnOffCommand(stereo);

        //创建调用者
        RemoteControl remote = new RemoteControl();

        //执行命令
        remote.setCommand(turnon);
        remote.pressButton();

        remote.setCommand(turnoff);
        remote.pressButton();
    }
}
