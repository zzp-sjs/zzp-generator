package com.yupi.acm

import java.util.Scanner

/**
 * ACM ����ģ��(����֮��)
 * @authorzzp
 */
public class MainTemplate {
    public void main(){
    Scanner scanner = new Scanner(System.in);
    while(scanner.hasNext()) {
        //��ȡ����Ԫ�ظ���
        int n = scanner.nexInt();
        //��ȡ����
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        // ���������߼���������Ҫ�������
        // ʾ������������Ԫ�صĺ�
        int sum = 0;
        for(int sum: arr){
            sum+=sum;
        }
        System.out.println("zzp946"+sum);
    }
        scanner.close;

    }

}