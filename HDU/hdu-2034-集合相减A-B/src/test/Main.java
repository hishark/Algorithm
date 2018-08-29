package test;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 题目鸡贼
 * 悄咪咪说了一句从小到大输出结果
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			int m = cin.nextInt();
			if(n==0&&m==0)
				break;
			else{
				int A[] = new int[n];
				int B[] = new int[m];
				for(int i=0;i<n;i++){
					A[i] = cin.nextInt();
				}
				for(int i=0;i<m;i++){
					B[i] = cin.nextInt();
				}
				for(int i=0;i<n;i++){
					for(int j=0;j<m;j++){
						if(A[i]==B[j]){
							A[i]=0;
						}
					}
				}
				int num = 0,ZeroNum=0;
				
				Arrays.sort(A);
				
				
				for(int i=0;i<n;i++){
					if(A[i]==0){
						ZeroNum++;
						continue;
					}else{
						System.out.print(+A[i]+" ");
					}
					if(i==n-1){
						System.out.println();
					}
				}
				
				if(ZeroNum==n){
					System.out.println("NULL");
				}
			}
		}
	}

}