package test;

import java.util.Scanner;
/*
 * 找规律
 * 发现是斐波那契数列
 * 然后写递归就好啦
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N = cin.nextInt();
			for(int i=0;i<N;i++){
				int M = cin.nextInt();
				System.out.println(dp(M));
			}
		}
	}

	private static int dp(int m) {
		// TODO Auto-generated method stub
		if(m==1)
			return 0;
		else if(m==2)
			return 1;
		else if(m==3)
			return 2;
		else
			return dp(m-1)+dp(m-2);
	}

}