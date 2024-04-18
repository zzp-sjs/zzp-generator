package com.zzp.cli.pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午3:52
 * @Description:
 */
public class TurnOnCommand implements Command{

    private Device device;

    public TurnOnCommand(Device device){
        this.device = device;
    }

    public void execute(){
        device.turnOff();
    }
}