package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
 * String.charAt应该经常要用到
 * 可以取出字符串中的某个字符
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			String a[] = new String[n];
			for(int i=0;i<n;i++){
				a[i] = cin.next();
			}
			
			for(int i=0;i<n;i++){
				int sum = 0;
				for(int j=0;j<a[i].length();j++){
					if(a[i].charAt(j)>='0'&&a[i].charAt(j)<='9'){
						sum++;
					}
				}
				System.out.println(sum);
			}
		}
	}
}
