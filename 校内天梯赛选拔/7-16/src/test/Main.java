package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int sum = 0;
		while(cin.hasNext()){
			int m = cin.nextInt();
			int n = cin.nextInt();
			sum++;
			int pre = m*n;
			int latex;
			if(n!=0){
				if(sum==1)
					System.out.print(pre+" "+(n-1));
				else
					System.out.print(" "+pre+" "+(n-1));
			}
				
			
			
		}
	}


}
