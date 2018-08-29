package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		
		String str = cin.nextLine();
		char c[] = str.toCharArray();
		int a[] = new int[c.length];
		for(int i=0;i<c.length;i++){
			a[i] = c[i] - '0';
		}
		long sum = 0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
		}
		 
		String result = String.valueOf(sum);
		 
		String num[]= new String[]{"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
		for(int i=0;i<result.length();i++){
			if(i==0)
				//这里别忘记-'0'啦！
				System.out.print(num[result.charAt(i)-'0']);
			else
				System.out.print(" "+num[result.charAt(i)-'0']);
		}
	}

}
