package test;

import java.util.Scanner;
/*
 * 如果输入的底数和指数较小用暴力就可以了
 * 如果输入的底数和指数较大用暴力就会超时，所以要用快速幂解法求解。--Unsolved
 * 
 * Solved--不要乘方后再求余 一边乘一边求余就不会溢出了
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int A = cin.nextInt();
			int B = cin.nextInt();
			if(A==0&&B==0)
				break;
			else{
				int t = 1;
				for(int i=0;i<B;i++){
					t=t*A%1000;
				}
				System.out.println(t);
			}
		}
	}

}