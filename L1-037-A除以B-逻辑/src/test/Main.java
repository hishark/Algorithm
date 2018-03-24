package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int A = cin.nextInt();
		int B = cin.nextInt();
		if(B>0){
			System.out.printf("%d/%d=%.2f",A,B,(double)A/B);
		}
		if(B<0){
			System.out.printf("%d/(%d)=%.2f",A,B,(double)A/B);
		}
		if(B==0)
			System.out.printf("%d/%d=Error",A,B);
		
	}
}
 