package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			String s ="";
			while(n>0){
				int t = n%2;
				s=s+t;
				n=n/2;
			}
			StringBuffer result = new StringBuffer(s);
			result.reverse();
			System.out.println(result);
		}
	}

}