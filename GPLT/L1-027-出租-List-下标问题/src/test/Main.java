package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine();
		boolean exists[] = new boolean[10]; 
		for(int i=0;i<str.length();i++){
			exists[str.charAt(i)-'0'] = true;
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i=exists.length-1;i>=0;i--){
			if(exists[i]==true){
				arr.add(i);
			}
		}
		 
		for(int i=0;i<str.length();i++){
			for(int j=0;j<arr.size();j++){
				if(str.charAt(i)-'0'==arr.get(j)){
					index.add(j);
				}
			}
		}
		System.out.print("int[] arr = new int[]{");
		System.out.print(arr.get(0));
		for(int i=1;i<arr.size();i++){
			System.out.print(","+arr.get(i));
		}
		System.out.println("};");
		
		System.out.print("int[] index = new int[]{");
		System.out.print(index.get(0));
		for(int i=1;i<index.size();i++){
			System.out.print(","+index.get(i));
		}
		System.out.println("};");
		
	}
}
 