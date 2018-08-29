package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
        	int m = cin.nextInt();
        	int n = cin.nextInt();
        	int num = 0;
        	for(int i=m;i<=n;i++){
        		if(isFlower(i)&&num==0){
        			System.out.print(i);
        			num++;
        			continue;
        		}
        		if(isFlower(i)&&num!=0){
        			System.out.print(" "+i);
        			num++;
        		}
        	}
        	
        	if(num==0){
        		System.out.println("no");
        	}else{
        		System.out.println();
        	}
        }
    }
    
    private static boolean isFlower(int x){
    	int x1,x2,x3;
    	x1 = x/100;
    	x2 = x/10%10;
    	x3 = x%10;
    	if(Math.pow(x1, 3)+Math.pow(x2, 3)+Math.pow(x3, 3)==x){
    		return true;
    	}else{
    		return false;
    	}
    }

}
