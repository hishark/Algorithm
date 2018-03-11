package test;

import java.util.Scanner;
/*
 * 注意负数的问题
 * StringBuffer.reverse
 * 注意是>=10不是>10噢不然就WA了
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N = cin.nextInt();
			int R = cin.nextInt();
			if(N<0){
				N=-N;
				System.out.print("-");
			}
			String s ="";
			while(N>0){
				int t = N%R;
				if(t>=10){
					char c = (char)(t-10+'A');
					s=s+c;
				}else{
					s=s+t;
				}
				N=N/R;
			}
			
			StringBuffer result = new StringBuffer(s);
			result.reverse();
			System.out.println(result);
		}
	}

}