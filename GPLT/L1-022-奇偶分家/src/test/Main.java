package test;

 

import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		int a[] = new int[N];
		int ji=0,ou=0;
		for(int i=0;i<N;i++){
			a[i] = cin.nextInt();
			if(a[i]%2==0)
				ou++;
			else
				ji++;
		}
		System.out.println(ji+" "+ou);
	}
}