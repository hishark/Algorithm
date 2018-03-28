package com.example.a777.pat_basic_level.PAT乙级1010一元多项式求导;

import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        boolean isFirst = true;
        while (cin.hasNext()){

            int a = cin.nextInt();
            int b = cin.nextInt();
            int pre,aft;
            if(isFirst&&b==0)
                System.out.print("0 0");
            if(b!=0){
                pre = a*b;
                aft = b-1;

                if (isFirst){
                    System.out.print(pre+" "+aft);
                    isFirst = false;
                }else{
                    System.out.print(" "+pre+" "+aft);
                }
            }
        }
    }
}
