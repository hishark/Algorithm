package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		for(int i=0;i<N;i++){
			int H = cin.nextInt();
			int W = cin.nextInt();//市斤
			double basic = (H-100)*0.9*2;//市斤
			
			if(Math.abs(W-basic)<basic*0.1){
				System.out.println("You are wan mei!");
			}else if(W<basic){
				System.out.println("You are tai shou le!");
			}else
				System.out.println("You are tai pang le!");
		}
		
	}
	
	 
}
 