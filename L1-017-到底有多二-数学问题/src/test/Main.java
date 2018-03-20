package test;

 
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		double multiple[] = new double[2];
		multiple[0] = 1+0.5;
		multiple[1] = 1+1;
		
		double er = 1;
		
		String S = cin.next();
		 
		
 
		
		int length=S.length();
	 
		if(S.charAt(0)=='-'){
			er = er * multiple[0];
			 
			length = S.length()-1;
			 
		}
		if((S.charAt(S.length()-1)-'0')%2==0){
			er = er * multiple[1];
		 
		}
		
		double Ernum = 0;

		for(int i=0;i<S.length();i++){
			if(S.charAt(i)=='2'){
				Ernum++;
			}
		}
	 
		er = er * (Ernum/length);
		er = er *100;
		System.out.printf("%.2f",er);
		System.out.print("%");
	}
}
