package test;

import java.util.Scanner;
/*
 * 错排数：f[n]=(n-1)(f[n-2]+f[n-1])
 * 排列组合 C(n,m)
 * http://blog.csdn.net/liwen_7/article/details/7646451
 * 一定一定要记得用long！！
 * int存不下
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		 
			int C = cin.nextInt();
			for(int i=0;i<C;i++){
				int N = cin.nextInt();
				int M = cin.nextInt();
				
				long a[] = new long[21];
				a[1] = 0;
				a[2] = 1;
				for(int j=3;j<21;j++){
					a[j] = (j-1)*(a[j-2]+a[j-1]);
				}
				
				if(N==M)
					System.out.println(a[M]);
				else
					System.out.println(C(N,M)*a[M]);
				
			} 
	}
	private static long C(int n, int m) {
		// TODO Auto-generated method stub
		return jc(n)/jc(m)/jc(n-m);
	}

	private static long jc(int n) {
		// TODO Auto-generated method stub
		if(n==0||n==1)
			return 1;
		else
			return n*jc(n-1);
		 
	}
}