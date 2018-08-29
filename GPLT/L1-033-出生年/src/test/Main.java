package test;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int year = cin.nextInt();
		int n = cin.nextInt();
		for(int i=year;i<=9999;i++){
			int temp = i;
			HashSet<Integer> s = new HashSet<>();
			for(int j=0;j<4;j++){
				s.add(temp%10);
				temp/=10;
			}
			
			if(s.size()==n){
				System.out.printf("%d %04d",i-year,i);
				break;
			}
		}
		
	}
}
 