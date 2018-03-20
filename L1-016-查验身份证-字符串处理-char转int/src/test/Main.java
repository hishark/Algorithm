package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		cin.nextLine();
		String a[] = new String[N];
		for (int i = 0; i < N; i++) {
			a[i] = cin.nextLine();
		}
		int pr[] = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

		int flag = 0;

		for (int i = 0; i < N; i++) {
			// 字符串的每个字符
			char c[] = a[i].toCharArray();

			// 加权和
			int sum = 0;

			// 求加权和
			for (int j = 0; j < 17; j++) {
				if (c[j] == 'X') {
					sum += pr[j] * 10;
					continue;
				}
				//你可能是猪 不-'0'怎么变成正确的数字哦
				sum += pr[j] * (c[j]-'0');
			}
			 
			int Z = sum % 11;
		 
			
			if (Z == 0 && c[c.length - 1] != '1') {
				System.out.println(a[i]);
				flag = 1;
				continue;
			}
			if (Z == 1 && c[c.length - 1] != '0') {
				System.out.println(a[i]);
				flag = 1;
				continue;
			}

			if (Z == 2 && c[c.length - 1] != 'X') {
				System.out.println(a[i]);
				flag = 1;
				continue;
			}

			if (Z != 0 && Z != 1 && Z != 2 && Z + (c[c.length - 1]-'0') != 12) {
				System.out.println(a[i]);
				flag = 1;
				continue;
			}
		}
		if(flag==0)
			System.out.println("All passed");
	}
}
