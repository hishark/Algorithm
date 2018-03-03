package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int score = cin.nextInt();
			if(score>=90&&score<=100)
				System.out.println("A");
			else if(score>=80&&score<=89)
				System.out.println("B");
			else if(score>=70&&score<=79)
				System.out.println("C");
			else if(score>=60&&score<=69)
				System.out.println("D");
			else if(score>=0&&score<=59)
				System.out.println("E");
			else
				System.out.println("Score is error!");
		}
	}

}
