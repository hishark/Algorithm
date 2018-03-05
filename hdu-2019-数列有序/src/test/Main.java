package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
 *Arrays.sort
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n,m;
			n = cin.nextInt();
			m = cin.nextInt();
			if(n==0&&m==0)
				break;
			int a[] = new int[n+1];
			for(int i=0;i<n;i++){
				a[i] = cin.nextInt();
			}
			a[n] = m;
			Arrays.sort(a);
			
			/*
			 * 写一个冒泡排序
			 * n+1是因为总共有n+1个数
			for(int i=0;i<n+1-1;i++){
				for(int j=0;j<n+1-1-i;j++){
					if(a[j]>a[j+1]){
						int temp = a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}
			}*/
			
			for(int i=0;i<n+1;i++){
				if(i==0)
					System.out.print(a[i]);
				else
					System.out.printf(" "+a[i]);
			}
			System.out.println();
		}
	}
}
