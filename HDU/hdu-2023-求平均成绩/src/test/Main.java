package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 大于等于啊小姐！！
 * 只写了大于当然WA啊智障！！
 * 还有测试用例后面要空一行也很鸡贼哼！
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int m = cin.nextInt();
			double grade[][] = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grade[i][j] = cin.nextInt();
				}
			}
			 
			double StuAvg[] = new double[n];
			double CorAvg[] = new double[m];
			int GoodBoy = 0;
			
			for (int i = 0; i < n; i++) {
				double sum = 0;
				for (int j = 0; j < m; j++) {
					sum+=grade[i][j];
				}
				StuAvg[i] = sum/m;
			}
			
			for (int i = 0; i < m; i++) {
				double sum = 0;
				for (int j = 0; j < n; j++) {
					sum+=grade[j][i];
				}
				CorAvg[i] = sum/n;
			}
			
			for (int i = 0; i < n; i++) {
				int num = 0;
				for (int j = 0; j < m; j++) {
					if(grade[i][j]>=CorAvg[j]){
						num++;
					}
				}
				if(num==m){
					GoodBoy++;
				}
			}
			for(int i=0;i<n;i++){
				if(i==0)
					System.out.printf("%.2f",StuAvg[i]);
				else{
					System.out.print(" ");
					System.out.printf("%.2f",StuAvg[i]);
				}
			}
			System.out.println();
			for(int i=0;i<m;i++){
				if(i==0)
					System.out.printf("%.2f",CorAvg[i]);
				else{
					System.out.print(" ");
					System.out.printf("%.2f",CorAvg[i]);
				}
			}
			System.out.println();
			System.out.println(GoodBoy);
			System.out.println();
		}
	}
}
