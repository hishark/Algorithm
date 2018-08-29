package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 哇我觉得这个方法超棒
 * 用到了StringBuffer.serCharAt 可以改变字符串指定位置的字符
 * 还用了String.split切割字符串
 * 强制类型转换是(char)()
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			String str = cin.nextLine();
			String word[] = str.split(" ");
			char Upper[] = new char[word.length];
			for(int i=0;i<word.length;i++){
				Upper[i] = (char)(word[i].charAt(0)-32);
			    StringBuffer str1 = new StringBuffer(word[i]);
			    str1.setCharAt(0, Upper[i]);
			    if(i==0)
			    	System.out.print(str1);
			    else
			    	System.out.print(" "+str1);
			    
			}
			System.out.println();
		}
		
	}
}
