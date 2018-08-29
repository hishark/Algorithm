package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int M = cin.nextInt();
			cin.nextLine();
			for(int i = 0;i<M;i++){
				String str = cin.nextLine();
				char c[] = str.toCharArray();
				if(c.length>=8&&c.length<=16){
					int A=0,B=0,C=0,D=0,sum=0;
					for(int j=0;j<c.length;j++){
						if(c[j]>='0'&&c[j]<='9')
							A=1;
						if(c[j]>='a'&&c[j]<='z')
							B=1;
						if(c[j]>='A'&&c[j]<='Z')
							C=1;
						if(c[j]=='~'||c[j]=='!'||c[j]=='@'||c[j]=='#'||c[j]=='$'||c[j]=='%'||c[j]=='^')
							D=1;
					}
					sum=A+B+C+D;
					if(sum>=3)
						System.out.println("YES");
					else
						System.out.println("NO");
				}else{
					System.out.println("NO");
				}
			}
		}
	}

}