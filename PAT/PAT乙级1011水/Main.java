package com.example.a777.pat_basic_level.PAT乙级1011水;

import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()){
            int T = cin.nextInt();
            for(int i=0;i<T;i++){
                long A = cin.nextInt();
                long B = cin.nextInt();
                long C = cin.nextInt();
                if(A+B>C){
                    System.out.printf("Case #%d: true\n",i+1);
                }else{
                    System.out.printf("Case #%d: false\n",i+1);
                }
            }

        }
    }
}
