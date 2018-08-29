package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N,K;
		N = cin.nextInt();
		K = cin.nextInt();
		int a[] = new int[N];
		for(int i=0;i<N;i++){
			a[i] = cin.nextInt();
		}
		
		//冒泡排序
		for(int i=0;i<N-1;i++){
			if(i==K){
				for(int x=0;x<N;x++){
					if(x==0)
						System.out.print(a[x]);
					else
						System.out.print(" "+a[x]);
				}
			}
			for(int j=0;j<N-1-i;j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}


}
