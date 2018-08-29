package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		String s = cin.next();
		char c = s.charAt(0);
		for(int i=1;i<=Math.round((double)N/2);i++){
			for(int j=1;j<=N;j++){
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println(Math.round((double)11/2));
	}	 
}

