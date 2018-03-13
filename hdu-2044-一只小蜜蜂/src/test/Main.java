package test;

import java.util.Scanner;
/*
 * 题意：简单递推
     解决：只管前后差值，每一个房子只能从左边两个过来，所以a[n]就只能从a[n-1]和a[n-2]过来
     细节：递推，注意最终的数据范围。
   array数组要用long长整型
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N = cin.nextInt();
			for(int i=0;i<N;i++){
				int a = cin.nextInt();
				int b = cin.nextInt();
				long array[] = new long[100];
				array[0] = 0;
				array[1] = 1;
				array[2] = 2;
				int j;
				for(j=3;j<=50;j++){
					array[j] = array[j-1] + array[j-2];
				}
				System.out.println(array[b-a]);
			}
		}
	}

}