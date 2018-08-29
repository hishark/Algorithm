package com.example.a777.pat_basic_level.PAT乙级1008数组元素循环右移问题;

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
            int N = cin.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            int move = cin.nextInt();
            //这里一定要处理一下move 因为move没有规定大小 如果大于n的话会数组越界
            move%=N;
            for(int i=0;i<N;i++){
                al.add(cin.nextInt());
            }
            ArrayList<Integer> result = new ArrayList<>();
            for(int i = al.size()-move;i<N;i++){
                result.add(al.get(i));
            }
            for(int i=0;i<al.size()-move;i++){
                result.add(al.get(i));

            }
            for(int i=0;i<result.size();i++){
                if(i==0)
                    System.out.print(result.get(i));
                else
                    System.out.print(" "+result.get(i));
            }
            System.out.println();
        }
    }
}
