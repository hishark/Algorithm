package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n = cin.nextInt();
			cin.nextLine();
			String str[] = new String[n];
			for(int i=0;i<n;i++){
				str[i] = cin.nextLine();
			}
			
			for(int i=0;i<n;i++){
				int num = 0;
				for(int j=0;j<str[i].length();j++){
					if(str[i].charAt(j)>128){
						num++;
					}
				}
				System.out.println(num);
			}
		}
	}

}