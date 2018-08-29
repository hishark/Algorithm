package test;

import java.util.Scanner;

/*
 * http://blog.csdn.net/it_dream_er/article/details/51261062
 * 奇数行从左往右
 * 偶数行从右往左
 * 
 * 到第n行一共有n(n+1)/2个元素
 * 第n行之前一共有n(n-1)/2个元素
 * 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int N = cin.nextInt();
			// 行和列
			int i, j;
			int fenzi = 0, fenmu = 0;
			// N位于第i行
			i = getRow(N);

			// 第i行前有h个元素
			int h = i * (i - 1) / 2;
			j = N - h;
			// 偶数行的分子从右往左数1、2、3、4...
			// 第几行 那么分子加分母就是几
			if (i % 2 == 0) {
				fenzi = j;
				fenmu = i+1-j;
			} else {
				// 奇数行的分母从左往右数1、2、3、4...
				fenzi = i+1-j;
				fenmu = j;
				
			}
			System.out.println(fenzi+"/"+fenmu);

		}
	}

	private static int getRow(int n) {
		// TODO Auto-generated method stub
		int i;
		for (i = 0; i < n; i++) {
			int sum = i * (i + 1) / 2;
			if (sum >= n)
				break;
		}
		return i;
	}

}