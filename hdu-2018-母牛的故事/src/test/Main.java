package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
 * 从小学开始我就不会找规律
 * 我是猪
 * TUT
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int a[] = new int[55];
			a[0] = 1;
			a[1] = 2;
			a[2] = 3;
			for(int i=3;i<a.length;i++){
				a[i] = a[i-1] + a[i-3];
			}
			while(cin.hasNext()){
				int n;
				n = cin.nextInt();
				if(n==0)
					break;
				System.out.println(a[n-1]);
			}
		}
	}
}
