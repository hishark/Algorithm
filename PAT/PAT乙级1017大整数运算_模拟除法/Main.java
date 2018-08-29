package com.example.a777.pat_basic_level.PAT乙级1017大整数运算_模拟除法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 模拟手动除法的过程，每次用第一位去除以B，
 * 如果得到的商不是0就输出，
 * 否则就*10+下一位，直到最后的数为余数～
 */

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        bf.close();
        String a[] = str.split(" ");
        String A = a[0];
        int B = Integer.parseInt(a[1]);

        int length = A.length();
        int t = (A.charAt(0) - '0') / B;
        if((t!=0&&length>1) || length==1){
            System.out.print(t);
        }
        int temp = (A.charAt(0)-'0')%B;
        for (int i=1;i<length;i++){
            t = (temp*10+A.charAt(i)-'0')/B;
            System.out.print(t);
            temp = (temp*10 + (A.charAt(i)-'0'))%B;
        }
        System.out.print(" "+temp);
    }


}
