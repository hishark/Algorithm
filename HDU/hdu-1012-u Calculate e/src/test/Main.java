package test;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("n e");
        System.out.println("- -----------");
        for(int i=0;i<=9;i++){
            System.out.print(i+" ");
            if(i==0||i==1)
                System.out.println((int)getE(i));
            else{
                if(i==2)
                    System.out.println(getE(i));
                else{
                    System.out.printf("%.9f",getE(i));
                    System.out.println();
                }
            }
        }
    }
    public static double getE(int n){
        double sum = 0;
        for(int i=0;i<=n;i++){
            sum += (double)1/jc(i);
        }
        return sum;
    }
    public static int jc(int n){
        if(n==0||n==1)
            return 1;
        else
            return n*jc(n-1);
    }
}
