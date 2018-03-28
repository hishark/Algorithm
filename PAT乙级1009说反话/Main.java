package com.example.a777.pat_basic_level.PAT乙级1009说反话;

import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            String str = cin.nextLine();
            String s[] = str.split(" ");
            for(int i=s.length-1;i>=0;i--){
                if(i==s.length-1)
                    System.out.print(s[i]);
                else
                    System.out.print(" "+s[i]);
            }
        }
    }
}
