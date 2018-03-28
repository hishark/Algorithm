package com.example.a777.pat_basic_level.PAT乙级1006换个格式输出整数;

import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        char c[] = str.toCharArray();
        int length = c.length;
        if(length==1){
            for(int i=1;i<=c[0]-'0';i++){
                System.out.print(i);
            }
        }else if(length==2){
            int shi = c[0]-'0';
            int ge = c[1]-'0';
            for(int i=1;i<=shi;i++){
                System.out.print("S");
            }
            for(int i=1;i<=ge;i++){
                System.out.print(i);
            }
        }else{
            int bai = c[0]-'0';
            int shi = c[1]-'0';
            int ge = c[2]-'0';
            for(int i=1;i<=bai;i++){
                System.out.print("B");
            }

            for(int i=1;i<=shi;i++){
                System.out.print("S");
            }
            for(int i=1;i<=ge;i++){
                System.out.print(i);
            }
        }
        System.out.println();

    }
}
