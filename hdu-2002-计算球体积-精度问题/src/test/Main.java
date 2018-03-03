package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		double PI = 3.1415927;
		while(cin.hasNext()){
			double r = cin.nextDouble();
			System.out.printf("%.3f",(double)4/3*PI*r*r*r);
			System.out.println();
		}
	}

}
