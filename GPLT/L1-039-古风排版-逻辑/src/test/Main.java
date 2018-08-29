package test;

import java.util.Scanner;

 

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		
		int N = cin.nextInt();
		cin.nextLine();
		String str = cin.nextLine();
		
		int length = str.length();
		int col = length/N;
		if(length%N!=0)
			col++;
		/*
		 * 记得全部初始化为0啊！！
		 */
		char num[][]=new char[N][col];
		for(int i=0;i<N;i++){
			for(int j=0;j<col;j++){
				num[i][j] = ' ';
			}
		}
 
		
		int position = 0;
		for(int i=col-1;i>=0;i--){
			for(int j=0;j<N;j++){
				if(position<=length-1){ 
					num[j][i] = str.charAt(position);
					position++;
				}
				
			}
		}
		
	 
		for(int i=0;i<N;i++){
			for(int j=0;j<col;j++){
				System.out.print(num[i][j]);
			}
			System.out.println();
		}
		
	}
}
 