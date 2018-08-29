package test;

import java.util.ArrayList;
import java.util.Scanner;
 /*
  * 这题用java超时
  * 用c++吧
  * http://blog.csdn.net/qq_34594236/article/details/51711315
  */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner cin = new Scanner(System.in);
			int N = cin.nextInt();
			ArrayList<Seat> sl = new ArrayList<Seat>(); 
			for(int i=0;i<N;i++){
				Seat s = new Seat();
				s.Id = cin.nextLong();
				s.preId = cin.nextInt();
				s.aftId = cin.nextInt();
				sl.add(s);
			}
			int M = cin.nextInt();
			int a[] = new int[M];
			for(int i=0;i<M;i++){
				a[i] = cin.nextInt();
			}
			cin.close();
			for(int j=0;j<M;j++){
				for(int i=0;i<N;i++){
					if(sl.get(i).preId==a[j]){
						System.out.println(sl.get(i).Id+" "+sl.get(i).aftId);
					}
				}
			}
		}
}
class Seat{
	long Id;
	int preId;
	int aftId;
}