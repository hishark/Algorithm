package test;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 感谢小哥
 * http://blog.csdn.net/amx50b/article/details/45770929
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int m = cin.nextInt();
			int a[] = new int[100];
			/*
			 * 给数组赋值，得到偶数序列
			 */
			for (int i = 0; i < 100; i++)
				a[i] = 2 * (i + 1);
			
			/*
			 * 给够m个的序列求和
			 */
			for (int i = 0; i < n / m; i++) {
				int sum = 0;
				for (int j = i * m; j < (i + 1) * m; j++)
					sum += a[j];
				if (i == 0)
					System.out.print(sum / m);
				else
					System.out.print(" " + sum / m);
			}
			
			/*
			 * 给不够m个的序列求和
			 */
			if (n % m != 0) {
				int sum = 0;
				for (int i = n - n % m; i < n; i++)
					sum += a[i];
				System.out.print(" " + sum / (n % m));
			}
			System.out.println();
		}
	}
}
