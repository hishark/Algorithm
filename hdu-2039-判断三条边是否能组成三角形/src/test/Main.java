package test;

import java.util.Scanner;
/*
 * 傻逼！题目又没说三条边是整数！当然用double！
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		 
			int M = cin.nextInt();
			for(int i=0;i<M;i++){
				double A = cin.nextDouble();
				double B = cin.nextDouble();
				double C = cin.nextDouble();
				if(A+B>C&&B+C>A&&A+C>B){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		
	}

}