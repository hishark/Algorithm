package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
 * Collection太好用了8！！！！
 * 无敌！！！
 * http://www.runoob.com/java/arrays-min-max.html
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n;
			n = cin.nextInt();
			if(n==0){
				break;
			}
			if(n!=0){
				Integer a[] = new Integer[n];
				for(int i=0;i<n;i++){
					a[i] = cin.nextInt();
				}
				int min = (int) Collections.min(Arrays.asList(a));
		        int position = 0;
				for(int i=0;i<n;i++){
		        	if(a[i]==min){
		        		position=i;
		        		break;
		        	}
		        }
				int temp = a[position];
				a[position] = a[0];
				a[0] = temp;
				
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
}
