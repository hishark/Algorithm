package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			/*
			 *这句不能少 
			 */
			cin.nextLine();
			String str[] = new String[n];
			
			for(int i=0;i<n;i++){
				str[i] = cin.nextLine();
			}
			
			for(int i=0;i<n;i++){
				int aNum = 0, eNum = 0, iNum = 0, oNum = 0, uNum = 0;
				
				for(int j=0;j<str[i].length();j++){
					
					if(str[i].charAt(j)=='a'){
						aNum++;
					}else if(str[i].charAt(j)=='e'){
						eNum++;
					}else if(str[i].charAt(j)=='i'){
						iNum++;
					}else if(str[i].charAt(j)=='o'){
						oNum++;
					}else if(str[i].charAt(j)=='u'){
						uNum++;
					}
				}
				
				if(i==0){
					System.out.println("a:"+aNum);
					System.out.println("e:"+eNum);
					System.out.println("i:"+iNum);
					System.out.println("o:"+oNum);
					System.out.println("u:"+uNum);
				}else{
					System.out.println();
					System.out.println("a:"+aNum);
					System.out.println("e:"+eNum);
					System.out.println("i:"+iNum);
					System.out.println("o:"+oNum);
					System.out.println("u:"+uNum);
				}
				
			}
			
			
		}
	}

}
