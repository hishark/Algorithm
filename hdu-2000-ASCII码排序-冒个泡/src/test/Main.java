package test;

import java.util.Scanner;
//tochararray太方便辣！
//冒泡排序
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			String str = cin.next();
			char cr[] = str.toCharArray();
			
			for(int i=0;i<3-1;i++){
				for(int j=0;j<3-1-i;j++){
					if(cr[j] > cr[j+1]){
						char temp = cr[j];
						cr[j] = cr[j+1];
						cr[j+1] = temp;
					}
				}
			}
			
			for(int i=0;i<3;i++){
				System.out.print(cr[i]);
				if(i!=2)
					System.out.print(" ");
			}
			System.out.println();
			
		}
	}

}
