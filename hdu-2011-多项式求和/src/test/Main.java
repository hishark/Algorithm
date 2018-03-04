package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        int m;//测试实例的个数
        m = cin.nextInt();
        int a[] = new int[100];
        for(int i=0;i<m;i++){
        	a[i] = cin.nextInt();
        }
        for(int i=0;i<m;i++){
        	System.out.printf("%.2f",sum(a[i]));
        	System.out.println();
        }
    }

	private static double sum(int i) {
		// TODO Auto-generated method stub
		/*
		 * 记得是double不是int噢智障
		 */
		double Sum = 0;
		for(int j=1;j<=i;j++){
			Sum += compute(j);
		}
		return Sum;
	}

	private static double compute(int i) {
		// TODO Auto-generated method stub
		
		return Math.pow(-1,i+1)*1.0/i;
	}

}
