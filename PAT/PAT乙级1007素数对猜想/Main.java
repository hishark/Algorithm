package com.example.a777.pat_basic_level.PAT乙级1007素数对猜想;

import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int N = cin.nextInt();
            int num = 0;

            for (int i=2;i<=N;i++){
                //这里要注意边界问题呀，i+2肯定不能超出N嘛！
                if(isSushu(i) && isSushu(i+2) && !isSushu(i+1) && (i+2)<=N){
                    num++;
                }
            }
            System.out.println(num);
        }




    }

    public static boolean isSushu(int n){
        if(n==1)
            return false;
        else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
    }
}
