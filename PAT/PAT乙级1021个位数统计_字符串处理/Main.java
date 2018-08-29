package com.example.a777.pat_basic_level.PAT乙级1021个位数统计_字符串处理;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String N = bf.readLine();
        char c[] = N.toCharArray();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < c.length; i++) {
            a[c[i] - '0']++;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                System.out.printf("%d:%d\n", i, a[i]);
            }
        }

    }

}
