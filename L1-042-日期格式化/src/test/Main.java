package test;


import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		 
		String USAyear = cin.nextLine();
		 
		
		String u[] = USAyear.split("-");
		
		String year,month,day;
		year = u[2];
		month = u[0];
		day = u[1];
		
		System.out.println(year+"-"+month+"-"+day);
		
		
	}
}

 
 