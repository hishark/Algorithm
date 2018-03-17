package test;

import java.util.Scanner;
 
public class Main {
	/*
	 * 本猪脑子做这个题目肯定会走很多弯弯绕绕
	 * 柳婼这个女孩子真的好厉害噢！
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner cin = new Scanner(System.in);
			//不要输入整数，直接对字符串进行处理
			String s = cin.nextLine();
			
			//最方便的一个操作 a数组就用来存储0-9十个数字出现的次数
			int a[] = new int[10];
			
			//char-'0'就是整型啦
			for(int i=0;i<s.length();i++){
				a[s.charAt(i)-'0']++;
			}
			
			//输出即可
			for(int i=0;i<10;i++){
				if(a[i]!=0){
					System.out.println(i+":"+a[i]);
				}
			}
		}
}