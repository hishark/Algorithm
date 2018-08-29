package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N = cin.nextInt();
			for(int i=0;i<N;i++){
				int a = cin.nextInt();
				int sum = 0;
				int num[] = new int[100];
				num[0] = 3;
				int j;
				for(j=1;j<=a;j++){
					num[j] = (num[j-1]-1)*2;
				}
				System.out.println(num[j-1]);
			}
		}
	}
 

}