package test;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 有个小坑就是输入的两个整数并不一定是有序的哦
 */
public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int begin = cin.nextInt();
            int end = cin.nextInt();
            if(begin>end){
            	int temp = begin;
            	begin = end;
            	end = temp;
            }
            int evenSum = 0;
            int oddSum = 0;
            for(int i=begin;i<=end;i++){
            	if(isChicken(i)){
            		oddSum += Math.pow(i, 3);
            	}else{
            		evenSum += Math.pow(i, 2);
            	}
            }
            System.out.println(evenSum+" "+oddSum);
        }
    }

    private static boolean isChicken(int num){
        if(num%2!=0)
            return true;
        else
            return false;
    }
}
