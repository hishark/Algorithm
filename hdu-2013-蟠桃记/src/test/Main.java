package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int sum = 1;
			int x = 1;
			for (int i = 0; i < n-1; i++) {
				x = 2 * x + 2;
			}
			System.out.println(x);
		}
	}
}
