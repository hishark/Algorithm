package com.example.a777.pat_basic_level.PAT乙级1013数素数;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()){
            int M = cin.nextInt();
            int N = cin.nextInt();
            int count = 0;
            int num = 2;
            ArrayList<Integer> al = new ArrayList<>();
            while (count<N){
                if(isSushu(num)){
                    count++;
                    if(count>=M)
                        al.add(num);
                }
                num++;
            }

            count=0;

            for(int i=0;i<al.size();i++){
                if(i%10==0){
                    System.out.print(al.get(i));
                    count++;
                }else{
                    System.out.print(" "+al.get(i));
                    count++;
                }
                if (count==10){
                    count=0;
                    System.out.println();
                }

            }

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
