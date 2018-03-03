package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n;
            n = cin.nextInt();
            int a[]=new int[100];
            for(int i=0;i<n;i++){
                a[i] = cin.nextInt();
            }
            int sum = 1;
            for(int i=0;i<n;i++){
                if(isChicken(a[i])){
                    sum*=a[i];
                }
            }
            System.out.println(sum);
            
        }
    }

    public static boolean isChicken(int num){
        if(num%2!=0)
            return true;
        else
            return false;
    }
}
