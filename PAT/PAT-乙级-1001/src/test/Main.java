package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		
		//Math.log(8)/Math.log(2)
		int n = cin.nextInt();
		if(n==1){
			System.out.println(0);
			return;
		}
		int num = 0;
		while(n!=1){
			if(n%2==0){
				n=n/2;
				num++;
			}else{
				n=(3*n+1)/2;
				num++;
			}
		}
		
		System.out.println(num);
	}

}
