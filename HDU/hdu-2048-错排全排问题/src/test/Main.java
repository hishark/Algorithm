package test;

import java.util.Scanner;
/*
 * 错排数：f[n]=(n-1)(f[n-2]+f[n-1])
 * 全排数：n!
 * http://blog.csdn.net/liwen_7/article/details/7646451
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int C = cin.nextInt();
			long a[] = new long[21];
			a[1] = 0;
			a[2] = 1;
			for(int i=3;i<21;i++){
				a[i] = (i-1)*(a[i-2]+a[i-1]);
			}
			for(int i=0;i<C;i++){
				 int n =cin.nextInt();
				 long fenmu = 1;
				 for(long j=1;j<=n;j++){
					 fenmu = fenmu * j;
				 }
				 long fenzi = a[n];
				 System.out.printf("%.2f",((double)fenzi/fenmu)*100);
				 System.out.println("%");
			}
		}
	}
}