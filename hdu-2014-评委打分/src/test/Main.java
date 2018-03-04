package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = cin.nextInt();
			}
			Arrays.sort(a);
			double sum = 0;
			for(int i=1;i<n-1;i++){
				sum += a[i];
			}
			System.out.printf("%.2f",sum/(n-2));
			System.out.println();
		}
	}
}
