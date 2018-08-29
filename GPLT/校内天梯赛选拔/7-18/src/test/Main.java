package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		int cusid[] = new int[N];
		ArrayList<Integer> ateam = new ArrayList<Integer>();
		ArrayList<Integer> bteam = new ArrayList<Integer>();
		for(int i=0;i<N;i++){
			cusid[i] = cin.nextInt();
			if(isChicken(cusid[i])){
				ateam.add(cusid[i]);
			}else{
				bteam.add(cusid[i]);
			}
		} 
		int A=0,B=0;
		for(int i=1;i<=N;i++){
			if(i%3==0){
				 
					System.out.print(" "+bteam.get(B));
				B++;
			}else{
				if(i==1)
					System.out.print(ateam.get(A));
				else
					System.out.print(" "+ateam.get(A));
				A++;
			}
			
		 
		}
		
	}
	
	public static boolean isChicken(int num){
        if(num%2!=0)
            return true;
        else
            return false;
    }

	

}
