package com.zzp.cli;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午8:40
 * @Description:
 */
public class Test {
}

//抽象类实现接口
abstract class zzp implements zzp946{
    public void zzp(){
        System.out.println("zzp946");
    }
}

interface zzp946 {
    void zzp();
}

class zzp666 extends zzp{

    @org.junit.jupiter.api.Test
    public void zzp(){
        System.out.println("zzp666");
    }

    public static void main(String[] args) {
        zzp zzp = new zzp666();
        zzp.zzp();
    }

}