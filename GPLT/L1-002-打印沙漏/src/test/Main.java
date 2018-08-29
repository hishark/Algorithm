package test;

import java.util.Scanner;
 
public class Main {
/*
 * pat垃圾啊啊啊啊注释不让写中文不早说啊啊啊啊啊什么鬼啊啊啊啊
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner cin=new Scanner(System.in);
		 
		 
		
			int N = cin.nextInt();
			String symbol = cin.next();
			int row = 0;
			 
			for(int i=1;i<N;i++){
				if(2*(i*i+2*i)+1>N){
					row = i - 1;
					break;
				}
			}
			 
			for(int i=row;i>=1;i--){
				for(int j=1;j<=row-i;j++){
					System.out.print(" ");
				}
				for(int j=1;j<=2*i+1;j++){
					System.out.print(symbol);
				}
				System.out.println();
			}
			 
			for(int i=0;i<row;i++){
				System.out.print(" ");
			}
			System.out.println(symbol);
			 
			for(int i=1;i<=row;i++){
				for(int j=1;j<=row-i;j++){
					System.out.print(" ");
				}
				for(int j=1;j<=2*i+1;j++){
					System.out.print(symbol);
				}
				System.out.println();
			}
			System.out.print(N-2*(row*row+2*row)-1);
		}
}