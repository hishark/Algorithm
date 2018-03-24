package test;

import java.util.Scanner;
/*
 * 判断素数的函数别忘记处理1返回false
 */
public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		for(int i=0;i<N;i++){
			long x = cin.nextLong();
			if(isSushu(x)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
		
	}
	
	public static boolean isSushu(long n){
		if(n==1)
			return false;
		
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
}
 