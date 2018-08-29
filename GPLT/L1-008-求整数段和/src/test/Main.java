package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int A = cin.nextInt();
		int B = cin.nextInt();
		int num = 0,sum = 0;
		for(int i=A;i<=B;i++){
			if(num%5==0&&num!=0)
				System.out.println();
			System.out.printf("%5d",i);
			num++;
			sum+=i;
			 
		}
		System.out.println();
		System.out.println("Sum = "+sum);
	}	
}





