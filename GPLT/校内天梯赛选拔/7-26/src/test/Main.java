package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine();
		String str1[] = str.split(" ");
 
		ArrayList<String> al = new ArrayList<String>();
		
		for(int i=0;i<str1.length;i++){
			//这里用" "会没有用 没法识别  要""才行
			if(str1[i]==""||str1[i].equals("")){
		 
				continue;
			}else{
				al.add(str1[i]);
			}
		}
		

		
		for(int i=0;i<al.size();i++){
			
			if(i==0)
				System.out.print(al.get(i).length());
			else if(i!=al.size()-1)
				System.out.print(" "+al.get(i).length());
			else
				System.out.print(" "+(al.get(i).length()-1));
		}	
		
	}


}
