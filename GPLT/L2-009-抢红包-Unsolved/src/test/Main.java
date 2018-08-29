package test;

  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args){
		 
		Scanner cin =new Scanner(System.in);
		int N = cin.nextInt();
		RedPacket rp[] = new RedPacket[N];
	
		for(int i=0;i<N;i++){
			rp[i] = new RedPacket();
			rp[i].money = 0;
			rp[i].getnum = 0;
		}
		
		for(int i=0;i<N;i++){
			int K = cin.nextInt();
			
			for(int j=0;j<K;j++){
				
				int person = cin.nextInt();
				double money = cin.nextDouble();
				
				//rp[person-1] = new RedPacket();
				
				rp[person-1].BossId = person;
				rp[person-1].money += money/100;
				
				rp[i].money -= money/100;
				rp[person-1].getnum ++;
			}
		}
		
		Arrays.sort(rp);
		
		for(int i=0;i<N;i++){
			 
			System.out.printf("%d %.2f\n",rp[i].BossId,rp[i].money);
		}
		

	}
	
	
	
}
class RedPacket implements Comparable{
	int BossId;
	double money;
	int getnum;
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		RedPacket rp = (RedPacket)o;
		
		if(money!=rp.money)
			return (money<rp.money)?1:-1;
		else if(getnum!=rp.getnum)
			return (getnum<rp.getnum)?1:-1;
		else
			return (BossId>rp.BossId)?1:-1;		 
	}
	
	
}
