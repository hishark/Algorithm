package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int duration[] = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
		while(cin.hasNext()){
			boolean isRN;
			String str = cin.nextLine();
			String a[] = str.split("/");
			int year=Integer.valueOf(a[0]),month=Integer.valueOf(a[1]),day=Integer.valueOf(a[2]);
			if(year%4==0&&year%100!=0||year%400==0){
				isRN = true;
			}
			else{
				isRN = false;
			}
			if(isRN){
				duration[2] = 29;
			}else{
				duration[2] = 28;
			}
			int days = 0;
			for(int i=1;i<=month-1;i++){
				days = days + duration[i];
			}
			days = days + day;
			System.out.println(days);
		}
	}

}
