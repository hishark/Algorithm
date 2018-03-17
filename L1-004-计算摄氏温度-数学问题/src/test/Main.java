package test;

import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner cin = new Scanner(System.in);
			int F = cin.nextInt();
			int C = 5*(F-32)/9;
			System.out.println("Celsius = "+C);
		}
}