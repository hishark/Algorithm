package test;


import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine();
		int pos = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				pos = i;
				break;
			}
		}
		String sub1 = str.substring(0, pos);
		String sub2 = str.substring(pos+1);
 
		boolean sub1ok = false,sub2ok = false;
		
		int num1 = 0;
		for(int i=0;i<sub1.length();i++){
			if(sub1.charAt(i)-'0'>=0 && sub1.charAt(i)-'0'<=9){
				num1++;
			}
		}
		
		int num2 = 0;
		for(int i=0;i<sub2.length();i++){
			if(sub2.charAt(i)-'0'>=0 && sub2.charAt(i)-'0'<=9){
				num2++;
			}
		}
		
		if(num1==sub1.length()){
			if(Integer.parseInt(sub1)>=1&&Integer.parseInt(sub1)<=1000){
				System.out.print(Integer.parseInt(sub1));
				sub1ok = true;
			}else{
				System.out.print("?");
			}
		}else{
			System.out.print("?");
		}
		
		System.out.print(" + ");
		
		if(num2==sub2.length()){
			if(Integer.parseInt(sub2)>=1&&Integer.parseInt(sub2)<=1000){
				System.out.print(Integer.parseInt(sub2));
				sub2ok = true;
			}else{
				System.out.print("?");
			}
		}else{
			System.out.print("?");
		}
		
		System.out.print(" = ");
	 
		if(sub1ok&&sub2ok){
			System.out.println(Integer.parseInt(sub1)+Integer.parseInt(sub2));
		}else{
			System.out.println("?");
		}
		
	}
}