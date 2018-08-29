package test;

import java.util.Scanner;
//蓝桥杯2017第一题
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] nums = new double[100][2];
		double sum = 0;
		for (int i = 0; i < 50; i++) {
			nums[i][0] = sc.nextDouble();
			nums[i][1] = sc.nextDouble();
		}
		for (int i = 0; i < 50; i++) {
			sum += (nums[i][0] * nums[i][1] / 100);

		}
		System.out.println(sum);
	}

}
