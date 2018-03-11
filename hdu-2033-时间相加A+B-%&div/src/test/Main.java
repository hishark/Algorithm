package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N = cin.nextInt();
			cin.nextLine();
			String time[] = new String[N];
			for(int i=0;i<N;i++){
				time[i] = cin.nextLine();
				//time2里存了一对时分秒
				String time2[] = time[i].split(" ");
				//System.out.println(Arrays.toString(time2));
				int AH,AM,AS,BH,BM,BS;
				AH = Integer.valueOf(time2[0]);
				AM = Integer.valueOf(time2[1]);
				AS = Integer.valueOf(time2[2]);
				BH = Integer.valueOf(time2[3]);
				BM = Integer.valueOf(time2[4]);
				BS = Integer.valueOf(time2[5]);
				int TH=0,TM=0,TS=0;
				//超过了60就进位，没超过就直接加
				if(AS+BS>=60){
					TM = TM+(AS+BS)/60;
					TS = (AS+BS)%60;
				}else{
					TS = AS+BS;
					
				}
				
				//超过了60就进位，没超过就直接加
				if(AM+BM>=60){
					TH = TH + (AM+BM)/60;
					TM = TM + (AM+BM)%60;
				}else{
					TM = AM+BM;
				}
				//时不会超滴
				TH=TH+AH+BH;
				
				System.out.println(TH+" "+TM+" "+TS);
				
			}
			
		}
	}

}