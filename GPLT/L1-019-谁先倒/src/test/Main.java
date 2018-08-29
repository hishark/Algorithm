package test;

import java.util.Scanner;
/*
 * if判断要写清楚了别搞错啦
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		
		int jia = cin.nextInt();
		int yi = cin.nextInt();
		int n = cin.nextInt();

		int J = jia;
		int Y = yi;

		for (int i = 0; i < n; i++) {
			int jiahan = cin.nextInt();
			int jiahua = cin.nextInt();
			int yihan = cin.nextInt();
			int yihua = cin.nextInt();

			int sum = jiahan + yihan;

			if(jiahua == sum && yihua !=sum)
				J--;
			if(yihua ==sum && jiahua!=sum)
				Y--;
		 
			
			if (J == -1) {
				System.out.println("A");
				System.out.println(yi - Y);
				break;
			}

			if (Y == -1) {
				System.out.println("B");
				System.out.println(jia - J);
				break;
			}

		}
	}
}
