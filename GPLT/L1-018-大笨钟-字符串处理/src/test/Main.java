package test;

 
import java.util.Scanner;
/*
 * %02d的意思是输出两位int型的数，如果不足两位，在前面补0
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String s = cin.nextLine();
		
		String time[] = s.split(":");

		int hour = Integer.valueOf(time[0]);
		int min = Integer.valueOf(time[1]);
		
		if(hour<=11||hour==12&&min==0)
			System.out.printf("Only %02d:%02d.  Too early to Dang.", hour, min);
		
		if(hour==12&&min>0&&min<=59)
			System.out.println("Dang");
		
		if(hour>12&&hour<=23){
			hour = hour - 12;
			for(int i=0;i<hour;i++){
				System.out.print("Dang");
			}
			if(min>0&&min<=59)
				System.out.print("Dang");
		}
		
	 
		 
	}
}
