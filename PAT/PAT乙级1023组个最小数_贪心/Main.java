package com.example.a777.pat_basic_level.PAT乙级1023组个最小数_贪心;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            int a[] = new int[10];
            int sum = 0;
            for(int i=0;i<10;i++){
                a[i]=cin.nextInt();
                sum+=a[i];
            }


            for(int i=1;i<10;i++){
                if(a[i]!=0){
                    System.out.print(i);

                    a[i]--;
                    break;
                }
            }


            for(int i=0;i<10;i++){
                if(a[i]!=0){
                    for(int j=0;j<a[i];j++){
                        System.out.print(i);
                    }
                }
            }
        }

    }

}
