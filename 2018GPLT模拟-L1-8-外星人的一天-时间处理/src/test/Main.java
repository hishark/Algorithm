package test;

  
import java.util.Scanner;
 
public class Main {
	
	
	public static void main(String[] args){
		 
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		cin.nextLine();
		for(int i=0;i<N;i++){
			
			String str = cin.nextLine();
			int day = str.charAt(0)-'0';
			String str2 = str.substring(2);
			String time[] = str2.split(":");
			int hh = Integer.parseInt(time[0]);
			int mm = Integer.parseInt(time[1]);
			
			int alienDay = 0;
			int alienHh = 0;
			int alienMm = 0;
			
			if(day==0){
				System.out.printf("0 %02d:%02d",hh,mm);
			}else{
				if(day==1||day==2){
					alienDay = 1;
				}
				if(day==3||day==4){
					alienDay = 2;
				}
				if(day==5||day==6){
					alienDay = 3;
				}

				
				
				if(hh%2==0){
					alienHh = hh/2;
					alienMm = mm/2;
				}
				else{
					alienHh = hh/2;
					alienMm = (60+mm)/2;
				}
				
				if(day==1||day==3|day==5){
					System.out.printf("%d %02d:%02d",alienDay,alienHh,alienMm);
					System.out.println();
				}else{
					System.out.printf("%d %02d:%02d",alienDay,12+alienHh,alienMm);
					System.out.println();
				}
				
				
			}
			
		}
		
	}
}

 


