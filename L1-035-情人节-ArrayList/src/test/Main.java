package test;

import java.util.ArrayList;
 
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		ArrayList<String> person = new ArrayList<String>();
		String str = cin.next();
		while(!str.equals(".")){
			person.add(str);
			str = cin.next();
		}
		if(person.size()>=14){
			System.out.println(person.get(1)+" and "+person.get(13)+" are inviting you to dinner...");
		}else if(person.size()>=2){
			System.out.println(person.get(1)+" is the only one for you...");
		}else{
			System.out.println("Momo... No one is for you ...");
		}
		
	}
}
 