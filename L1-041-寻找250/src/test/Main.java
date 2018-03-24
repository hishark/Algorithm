package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n;
		ArrayList<Integer> a =  new ArrayList<Integer>();
		while(cin.hasNext()){
			n = cin.nextInt();
			a.add(n);
			if(n==250){
				System.out.println(a.indexOf(250)+1);
				break;
			}
				
		}
	}
}

 
 