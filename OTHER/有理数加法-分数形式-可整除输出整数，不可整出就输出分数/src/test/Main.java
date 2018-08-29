package test;

import java.util.Scanner;
/*
 * 这个题目不难你可能是猪
 * 就是个化简问题呀傻子
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int a1,b1,a2,b2,m,n;
			
			String str1 = cin.nextLine();
			//这里存好了两个分数
			String str2[] = str1.split(" ");
			//第一个数的分子[0]和分母[1]
			String str21[] = str2[0].split("/");
			//第二个数的分子[0]和分母[1]
			String str22[] = str2[1].split("/");
			
			a1 = Integer.valueOf(str21[0]);
			b1 = Integer.valueOf(str21[1]);
			a2 = Integer.valueOf(str22[0]);
			b2 = Integer.valueOf(str22[1]);
			
			//将两个分式通分 得到分子n和分母m
			m = b1*b2;
			n = a1*b2+a2*b1;
			
			//如果能整除就输出整数
			if(n%m==0)
				System.out.println(n/m);
			//如果不能整除，则将结果的分子式化到最简
			else{
				//从2开始循环判断能否被某个数整除化简
				for(int i=2;i<=m&&i<=n;i++){
					if(n%i==0 && m%i==0){
						n = n/i;
						m = m/i;
						i--;
					}
				}
				System.out.println(n+"/"+m);
			}
		}
	}

}