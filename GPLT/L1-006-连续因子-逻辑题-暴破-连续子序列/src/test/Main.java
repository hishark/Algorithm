package test;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();

		/*
		 * 这里如果不这么处理一下的话，暴力会超时的！一定要开个根号！开个根号少了超多计算量
		 */
		int max = (int) Math.sqrt(n);

		/*
		 * 题目说N最大是2的31次方 2的31次方介于12!~13! 所以连续因子的长度不会超过12
		 */
		for (int len = 12; len >= 1; len--) {
			for (int start = 2; start <= max; start++) {
				/*
				 * ans为连续因子的乘积
				 */
				long ans = 1;
				
				/*
				 * i-start+1是从开始位置到当前位置的长度 若小于等于len就一直乘
				 */
				for (int i = start; i - start + 1 <= len; i++)
					ans = ans * i;

				/*
				 * 如果找到了这样一个子序列 就把他输出来 然后return结束
				 */
				if (n % ans == 0) {
					System.out.println(len);
					System.out.print(start);
					for (int i = start + 1; i - start + 1 <= len; i++) {
						System.out.print("*" + i);
					}
					System.out.println();
					return;
				}
			}
		}
		System.out.println(1);
		System.out.println(n);
	}
}





