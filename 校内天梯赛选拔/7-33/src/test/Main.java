package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String str1 = cin.nextLine();
			//这里存好了两个分数
			String str2[] = str1.split(" ");
			//第一个数的分子[0]和分母[1]
			String str21[] = str2[0].split("/");
			//第二个数的分子[0]和分母[1]
			String str22[] = str2[1].split("/");
			
			int fenmu = GetMin(Integer.valueOf(str21[1]),Integer.valueOf(str22[1]));
		 
			double sum = Double.valueOf(str21[0]) / Double.valueOf(str21[1])
					+ Double.valueOf(str22[0]) / Double.valueOf(str22[1]);
			 
			
			String xiaoshu =String.valueOf(sum);
			
			String[] array = new String[2];  
	        array = xiaoshu.split("\\.");  
	        int a = Integer.parseInt(array[0]);//获取整数部分  
	        int b = Integer.parseInt(array[1]);//获取小数部分  
	        int length = array[1].length();  
	        int FenZi = (int) (a * Math.pow(10, length) + b);  
	        int FenMu = (int) Math.pow(10, length);  
	        int MaxYueShu = GetMax(FenZi, FenMu);  
	        
	        if(FenMu / MaxYueShu==1)
	        	System.out.println(FenZi / MaxYueShu);
	        else
	        	System.out.println(FenZi / MaxYueShu + "/" + FenMu / MaxYueShu);
		}
	}
	
	private static int GetMin(int a, int b) {
		// TODO Auto-generated method stub
		
		return a*b/GetMax(a,b);
	}

	private static int GetMax(int a, int b) {
		// TODO Auto-generated method stub
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (a != 0) {
			int c = b % a;
			b = a;
			a = c;
		}

		return b;
	}


}
