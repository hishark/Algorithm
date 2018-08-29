package test;

 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//Scanner cin = new Scanner(System.in);
		String str ;
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str = bf.readLine();
		 
		str = str.toUpperCase();
		int num[] = new int[4];
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='G')
				num[0]++;
			if(str.charAt(i)=='P')
				num[1]++;
			if(str.charAt(i)=='L')
				num[2]++;
			if(str.charAt(i)=='T')
				num[3]++;
		}
		
		while(num[0]!=0||num[1]!=0||num[2]!=0||num[3]!=0){
			for(int i=0;i<4;i++){
				if(num[i]!=0){
					if(i==0)
						System.out.print("G");
					if(i==1)
						System.out.print("P");
					if(i==2)
						System.out.print("L");
					if(i==3)
						System.out.print("T");
					num[i]--;
				}
			}
		}
	}
}