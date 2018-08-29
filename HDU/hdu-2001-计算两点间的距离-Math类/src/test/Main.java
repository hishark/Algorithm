package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		double x1,y1,x2,y2;
		while(cin.hasNext()){
			x1=cin.nextDouble();
			y1=cin.nextDouble();
			x2=cin.nextDouble();
			y2=cin.nextDouble();
			double result = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
			System.out.printf("%.2f",result);
			System.out.println();
		}
	}

}
