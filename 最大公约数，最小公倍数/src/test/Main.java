package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
		
			int a = cin.nextInt();
			int b = cin.nextInt();
			int max = GetMax(a, b);
			int min = GetMin(a, b);
			System.out.println(max);
			System.out.println(min);
		}
	}

	private static int GetMin(int a, int b) {
		// TODO Auto-generated method stub
		
		return a*b/GetMax(a,b);
	}

	private static int GetMax(int a, int b) {
		// TODO Auto-generated method stub
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (a != 0) {
			int c = b % a;
			b = a;
			a = c;
		}

		return b;
	}

}
