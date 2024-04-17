package com.yupi.acm

import java.util.Scanner

/**
 * ACM 输入模板(多数之和)
 * @author zzp
 */
public class MainTemplate {
    public void main(){
    Scanner scanner = new Scanner(System.in);
        //读取输入元素个数
        int n = scanner.nexInt();
        //读取数组
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        // 处理问题逻辑，根据需要进行输出
        // 示例：计算数组元素的和
        int sum = 0;
        for(int sum: arr){
            sum+=sum;
        }
        System.out.println("sum = "+sum);
        scanner.close;

    }

}