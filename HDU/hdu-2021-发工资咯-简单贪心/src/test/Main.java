package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 简单贪心题
 * 尽可能用大面值发工资会使得张数最少
 * 3%10=0
 * 3/10=0
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int money[] = new int[] { 100, 50, 10, 5, 2, 1 };
		while (cin.hasNext()) {
			int n = cin.nextInt();
			if (n == 0)
				break;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				int m = cin.nextInt();

				for (int j = 0; j < money.length; j++) {
					sum = sum + m / money[j];
					m = m % money[j];
				}
			}
			System.out.println(sum);
		}
	}
}
