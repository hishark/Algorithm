package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);

		int N = cin.nextInt();

		String a[] = new String[N];
		for (int i = 0; i < N; i++) {
			a[i] = cin.next();
		}

		String result;

		if (N == 1)
			result = a[0];
		else
			result = getFenshuSum(a[0], a[1]);
		for (int i = 2; i < N; i++) {
			result = getFenshuSum(result, a[i]);
		}

		 

		String str3[] = result.split("/");
		long m = Long.valueOf(str3[0]);
		long n = Long.valueOf(str3[1]);
		if (m % n == 0)
			System.out.println(m / n);
		else {
			if (m / n != 0)
				System.out.print(m / n + " ");
			System.out.println(m % n + "/" + n);
		}

	}

	private static String getFenshuSum(String str1, String str2) {

		// 第一个数的分子[0]和分母[1]
		String str21[] = str1.split("/");
		// 第二个数的分子[0]和分母[1]
		String str22[] = str2.split("/");

		long a1, b1, a2, b2, m, n;

		a1 = Long.valueOf(str21[0]);
		b1 = Long.valueOf(str21[1]);
		a2 = Long.valueOf(str22[0]);
		b2 = Long.valueOf(str22[1]);

		// 将两个分式通分 得到分子n和分母m
		m = b1 * b2;
		n = a1 * b2 + a2 * b1;

	 
		
	
		/*
		 * 从2开始循环判断能否被某个数整除化简
		 * 妈耶这里一定要记得加绝对值 不然负数进都进不去这个循环了OTZ
		 */
		for (long i = 2; i <= Math.abs(m) && i <= Math.abs(n); i++) {
			if (n % i == 0 && m % i == 0) {
				n = n / i;
				m = m / i;
				 
				/*
				 * 如果找到了这么一个可以整除的数 就反复的整除到无法整除为止！ 所以才会i--啦！
				 */
				i--;
			}
		}
		
		return n + "/" + m;
	 
	}
}
