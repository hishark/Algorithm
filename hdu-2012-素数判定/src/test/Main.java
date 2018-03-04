package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
        	int x = cin.nextInt();
        	int y = cin.nextInt();
        	int num = 0;
        	if(x==0&&y==0)
        		return;
        	for(int i=x;i<=y;i++){
        		if(isSuShu(i*i+i+41)){
        			num++;
        		}
        	}
        	if(num==y-x+1){
        		System.out.println("OK");
        	}else{
        		System.out.println("Sorry");
        	}
        }
    }
    
    private static boolean isSuShu(int x){
    	if(x==1)
    		return false;
    	for(int i=2;i<=Math.sqrt(x);i++){
    		if(x%i==0)
    			return false;
    	}
    	return true;
    }
}
