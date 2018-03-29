package com.example.a777.pat_basic_level.PAT乙级1019数字黑洞_字符串处理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;


/**
 * Created by 777 on 2018/3/28.
 * BufferReader万岁！AC啦！
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        bf.close();
        char c[] = str.toCharArray();

        int result = 0;

        do {
            Arrays.sort(c);
            //字符数组转字符串不能用toString哦
            String s1 = new String(c);
            //这里记得不足4位的补0
            int s1_length = s1.length();
            if(s1_length<4){
                for(int i=0;i<4-s1_length;i++){
                    s1="0"+s1;
                }
            }


            StringBuffer temp = new StringBuffer(s1);
            String s2 = temp.reverse().toString();

            int pre = Integer.parseInt(s2);
            int aft = Integer.parseInt(s1);

            result = pre - aft;

            System.out.printf("%04d - %04d = %04d\n", pre, aft, result);

            //结果不足四位补0
            String s3 = String.valueOf(result);
            int length = s3.length();
            if (length < 4) {
                for (int i = 0; i < 4 - length; i++) {
                    s3 = "0" + s3;
                }
            }
            c = s3.toCharArray();


        } while (result != 6174 && result != 0);


    }


}
