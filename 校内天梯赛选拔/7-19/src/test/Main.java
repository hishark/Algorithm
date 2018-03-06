package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		int K = cin.nextInt();
		int x = cin.nextInt();
		int num = 0;
		while(x>=0){
			al.add(x);
			num++;
			x = cin.nextInt();
		}
	 
		if(K>num||K<1){
			System.out.println("NULL");
		}else{
			System.out.println(al.get(num-K));
		}
		
		
		//System.out.println(al.toString());
		 
	}


}
