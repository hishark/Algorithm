package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		double sum = Math.pow(2, n);
		int s = (int)sum;
		System.out.println("2^"+n+" = "+s);
	}
}

