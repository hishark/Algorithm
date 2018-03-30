package com.example.a777.pat_basic_level.PAT乙级1022_D进制的A加B;



import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;



/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input  = bf.readLine();
        String par[] = input.split(" ");
        long A = Long.parseLong(par[0]);
        long B = Long.parseLong(par[1]);
        long D = Long.parseLong(par[2]);
        long result = A+B;
        if(result==0){
            System.out.println(0);
            return;
        }
        ArrayList<Long> al = new ArrayList<>();
        while(result!=0){
            long a = result%D;
            al.add(a);
            result = result/D;
        }
        for(int i=al.size()-1;i>=0;i--){
            System.out.print(al.get(i));
        }
        System.out.println();

    }

}
