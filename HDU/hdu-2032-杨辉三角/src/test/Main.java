package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			int a[][] = new int[n][n];
			for(int i=0;i<n;i++){
				a[i][0] = 1;
				a[i][i] = 1;
			}
			
			for(int i=2;i<n;i++){
				for(int j=1;j<i;j++){
					a[i][j]=a[i-1][j-1]+a[i-1][j];
				}
			}
			
			
			for(int i=0;i<n;i++){
				for(int j=0;j<i+1;j++){
					if(j==0){
						System.out.print(a[i][j]);
					}else{
						System.out.print(" "+a[i][j]);
					}
				}
				System.out.println();
			}
			System.out.println();
			 
		}
	}

}