package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
        	double n = cin.nextDouble();
        	int m = cin.nextInt(); 	
        	double sum = 0;
        	for(int i=0;i<m;i++){
        		sum += n;
        		n = Math.sqrt(n);
        	}
        	System.out.printf("%.2f",sum);
        	System.out.println();
        }
    }

}
