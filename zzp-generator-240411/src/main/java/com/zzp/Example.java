package com.zzp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/07/22/下午12:58
 * @Description:
 */

class Example {
    static int count = 0;

    Example() {
        count++;
    }
}

 class Test {
    public static void main(String[] args) {
        Example obj1 = new Example();
        Example obj2 = new Example();
        System.out.println(Example.count); // 输出: 2
    }
}
