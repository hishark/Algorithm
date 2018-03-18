package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		long a[] = new long[3];
		for(int i=0;i<3;i++){
			a[i] = cin.nextLong();
		}
		/*
		 * 冒个泡
		 */
		Arrays.sort(a);
		for(int i=0;i<3-1;i++){
			for(int j=0;j<3-1-i;j++){
				if(a[j]>a[j+1]){
					long temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		for(int i=0;i<3;i++){
			if(i==0)
				System.out.print(a[i]);
			else
				System.out.print("->"+a[i]);
		}
		
	}

}
