package com.zzp.cli.pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午3:43
 * @Description:
 */
public class TurnOffCommand implements Command{

    private Device device;

    public TurnOffCommand(Device device){
        this.device = device;
    }

    public void execute(){
        device.turnOff();
    }
}
