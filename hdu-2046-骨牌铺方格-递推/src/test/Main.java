package test;

import java.util.Scanner;
/*
 * http://blog.csdn.net/silenceneo/article/details/47679695
 * 递推的多来几个终于懂了！！！
 * 啊啊啊开心！！！
 * 
 * 思路——显然f(1)=1,f(2)=2,f(3)=3,现在我们考察最后一列：如果最后一列是竖着放的，那么方案数为f(n-1);
 * 如果最后一列是横着放的，那么必是两个横着放，此时方案数为f(n-2).
 * 因此，f(n)=f(n-1)+f(n-2),n>2,即为Fibonacci数。又因为n最大为50，所以直接递推即可。
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N = cin.nextInt();
			long a[] = new long[51];
			a[1]=1;
			a[2]=2;
			a[3]=3;
			for(int i=4;i<=50;i++){
				a[i] = a[i-1] + a[i-2];
			}
			System.out.println(a[N]);
		}
	}

}