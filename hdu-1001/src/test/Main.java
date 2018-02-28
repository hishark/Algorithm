package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
            System.out.println();
        }
    }
	/*
	 * 直接用n*(n+1)/2会溢出
	      如果判断奇数偶数再进行求和就没毛病
	      那干脆直接循环求和啦
	 */

}
