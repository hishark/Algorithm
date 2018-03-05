package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 我可能是智障
 * 为什么要插入好(max)了之后再输出
 * 比较到最大的紧接着输出一个(max)不就好了？？
 * 傻逼傻逼
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			String str = cin.next();
			char c[] = str.toCharArray();
			char max = c[0];
			for(int i=1;i<c.length;i++){
				if(c[i]>max)
					max=c[i];
			}
			for(int i=0;i<c.length;i++){
				if(c[i]==max)
					System.out.print(c[i]+"(max)");
				else
					System.out.print(c[i]);
			} 
			System.out.println();
		}
		
	}
}
