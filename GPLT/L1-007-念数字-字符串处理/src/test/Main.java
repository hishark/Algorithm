package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String s = cin.nextLine();
		char a[] = s.toCharArray();
		for(int i=0;i<a.length;i++){
			if(i==0)
				System.out.print(swap(a[i]));
			else
				System.out.print(" "+swap(a[i]));
		}
	}
	
	private static String swap(char a){
		switch(a){
		case '0':
			return "ling";
		case '1':
			return "yi";
		case '2':
			return "er";
		case '3':
			return "san";
		case '4':
			return "si";
		case '5':
			return "wu";
		case '6':
			return "liu";
		case '7':
			return "qi";
		case '8':
			return "ba";
		case '9':
			return "jiu";
		case '-':
			return "fu";
		default:
			return "ha";
		}
	}
}





