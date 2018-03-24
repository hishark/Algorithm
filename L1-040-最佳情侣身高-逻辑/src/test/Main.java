package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		for(int i=0;i<N;i++){
			person p = new person(cin.next(),cin.nextDouble());
			if(p.sex.equals("M")){
				System.out.printf("%.2f",p.height/1.09);
				System.out.println();
			}else{
				System.out.printf("%.2f",p.height*1.09);
				System.out.println();
			}
		}
	}
}

class person{
	String sex;
	double height;
	person(String a,double b){
		sex = a;
		height = b;
	}
}
 