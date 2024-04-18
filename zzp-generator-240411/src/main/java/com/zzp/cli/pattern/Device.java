package com.zzp.cli.pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午3:50
 * @Description:
 */
public class Device {
    private String name;

    public Device(String name) {this.name = name;}

    public void turnOn() {
        System.out.println(name + "Device is turned on");
    }

    public void turnOff() {
        System.out.println(name + "Device is turned off");
    }
}
