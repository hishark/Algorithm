package test;

import java.util.Scanner;
/*
 * http://blog.csdn.net/why850901938/article/details/50116937
 * 找规律 递推
 * 找到公式 f[n]=f[n-1]+f[n-2]*2
 * 我算是发现了，这种递推的题目基本都限制50个
 * 然后都要用long！！！
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N = cin.nextInt();
			long f[] = new long[51];
			f[1] = 3;
			f[2] = 6;
			f[3] = 6;
			int i;
			for(i=4;i<=N;i++){
				f[i] = f[i-1] + 2*f[i-2];
			}
			System.out.println(f[N]);
		}
	}

}