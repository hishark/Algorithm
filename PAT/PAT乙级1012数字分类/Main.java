package com.example.a777.pat_basic_level.PAT乙级1012数字分类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */
/*
java超时 100ms让人活？？？
 */
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()){
            int N = cin.nextInt();
            int a[] = new int[N];
            for (int i=0;i<N;i++){
                a[i] = cin.nextInt();
            }
            int A1sum=0;
            int sum = 0;
            int flag = 1;
            int num = 0;
            int num1 = 0;
            int sum1 = 0;
            double avg = 0;
            boolean a1=false,a2=false,a3=false,a4=false,a5=false;
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(a[i]%5==0&&a[i]%2==0){
                    A1sum+=a[i];
                    a1=true;
                }


                if(a[i]%5==1){
                    sum+=(flag)*a[i];
                    a2=true;
                    flag = -flag;
                }

                if(a[i]%5==2){
                    num++;
                    a3=true;
                }

                if(a[i]%5==3){
                    num1++;
                    sum1+=a[i];
                    a4 = true;
                }
                if(a[i]%5==4){
                    al.add(a[i]);
                    a5=true;
                }

            }

            if(a1)
                System.out.print(A1sum);
            else
                System.out.print("N");

            if(a2)
                System.out.print(" "+sum);
            else
                System.out.print(" N");

            if (a3)
                System.out.print(" "+num);
            else
                System.out.print(" N");

            if (a4){
                avg=(double)sum1/num1;
                System.out.printf(" %.1f",avg);
            }else
                System.out.print(" N");

            if (a5){
                int max = Collections.max(al);
                System.out.print(" "+max);
            }else
                System.out.print(" N");




            //avg = (double)sum1/num1;



        }
    }
}
