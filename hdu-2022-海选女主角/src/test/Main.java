package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * break只能跳出一层循环噢
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int m = cin.nextInt();
			int n = cin.nextInt();
			int a[][] = new int[m][n];
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					a[i][j] = cin.nextInt();
				}
			}
			int b[] = new int[m*n];
			int x = 0;
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					b[x] = Math.abs(a[i][j]);
					x++;
				}
			}
			Arrays.sort(b);
			int positionM = 0,positionN = 0;
			boolean flag = false;
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(Math.abs(a[i][j])==b[m*n-1]){
						positionM = i;
						positionN = j;
						flag = true;
						break;
					}
				}
				if(flag)
					break;
			}
			System.out.println((positionM+1)+" "+(positionN+1)+" "+a[positionM][positionN]);
			
		}
	}
}
