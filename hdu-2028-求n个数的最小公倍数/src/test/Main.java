package test;

import java.util.Scanner;
 /*
  * 你可以假设最后的输出是一个32位的整数。
  * ↑注意题目里的这句话哦
  * 所以不要用int 会WA 
  * 用long就AC了
  *
  */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			long a[] = new long[n];
			for(int i=0;i<n;i++){
				a[i] = cin.nextLong();
			}
			
			long temp = 1,min=0;
			for(int i=0;i<n;i++){
				min = getMin(temp,a[i]);
				temp = min;
			}
			System.out.println(min);
		}
	}
	
	public static long getMin(long a,long b){
		return a*b/getMax(a,b);
	}
	
	public static long getMax(long a,long b){
		if(a>b){
			long temp = a;
			a = b;
			b = temp;
		}
		
		while(a!=0){
			long c = b%a;
			b=a;
			a=c;
		}
		return b;
		
	}

}
