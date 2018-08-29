package test;


import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int D = cin.nextInt();
		if(D==5)
			System.out.println("7");
		else
			System.out.println((D+2)%7);
	}
}