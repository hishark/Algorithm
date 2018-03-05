package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
 *冒泡排序
 *Math.abs
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			if(n==0)
				break;
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = cin.nextInt();
			}
			for(int i=0;i<n-1;i++){
				for(int j=0;j<n-1-i;j++){
					if(Math.abs(a[j])<Math.abs(a[j+1])){
						int temp =  a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}
				}
			}
			for(int i=0;i<n;i++){
				if(i==0)
					System.out.print(a[i]);
				else
					System.out.print(" "+a[i]);
			}
			System.out.println();
		}
	}
}
