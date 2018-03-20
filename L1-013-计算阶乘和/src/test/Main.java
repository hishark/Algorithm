package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		long N = cin.nextLong();
		long S = 0;
		for(int i=1;i<=N;i++){
			S = S + getJc(i);
		}
		System.out.println(S);
	}
	
	public static long getJc(long n){
		if(n==1||n==0)
			return 1;
		else
			return n*getJc(n-1);
	}
}

