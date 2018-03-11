package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		int M = cin.nextInt();
		for(int i=0;i<M;i++){
			int A = cin.nextInt();
			int B = cin.nextInt();
			int a[] = new int[100];
			int b[] = new int[100];
			int Aposition = 0,Bposition=0;
			for(int j=1;j<=A/2;j++){
				if(A%j==0){
					a[Aposition] = j;
					Aposition++;
				}
			}
			 
			for(int j=1;j<=B/2;j++){
				if(B%j==0){
					b[Bposition] = j;
					Bposition++;
				}
			}
			 
			int Asum=0,Bsum=0;
			for(int j=0;j<Aposition;j++){
				Asum+=a[j];
			}
			for(int j=0;j<Bposition;j++){
				Bsum+=b[j];
			}
			
			if(A==Bsum&&B==Asum){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}