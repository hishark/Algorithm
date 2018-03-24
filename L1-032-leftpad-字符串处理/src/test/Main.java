package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		String s = cin.next();
		cin.nextLine();
		char c = s.charAt(0);
		String str = cin.nextLine();
		
		if(str.length()>=N){
			String sub = str.substring(str.length()-N);
			System.out.println(sub);
		}else{
			for(int i=0;i<N-str.length();i++){
				System.out.print(c);
			}
			System.out.println(str);
		}
		
	}
	
	 
}
 