package test;

import java.util.Scanner;
/*
 * http://blog.csdn.net/hy1405430407/article/details/43532525
 * 
设n位字符串，最后一位是O的字符串的个数为a[n],最后一位不是O的字符串的个数是b[n],
总字符串个数为x[n]，
则有
x[n]=a[n]+b[n];
a[n]=b[n-1];
b[n]=2*x[n-1];
====>x[n]=2*x[n-1]+2*x[n-2]

a[n]=b[n-1];这里很关键，因为上一次这里最后一定不是O（因为OO不能在一起！），所以这一次在上一次最后加上O即可。
 
 *
 *还有一位朋友的思路是这样的，不要列公式，很快
 *假设有f(n)种不同的串
 *当第n个是o时，那么第n-1个不能为o，此种情况有f(n-2)*2个
 *当第n个不是o时，有f(n-1)*2个
 *即f(n)=f(n-1)*2+f(n-2)*2;
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			long a[] = new long[50];
			a[1] = 3;
			a[2] = 8;
			for(int i=3;i<50;i++){
				a[i] = 2*a[i-2]+2*a[i-1];
			}
			System.out.println(a[n]);
		}
	}

}