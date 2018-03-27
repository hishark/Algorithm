package test;

 
import java.util.Scanner;
/*
 * 所以一句话总结字符串的要求：只能有一个P一个T，中间末尾和开头可以随便插入A。
 * 但是必须满足开头的A的个数 * 中间的A的个数 = 结尾的A的个数
 * 
 * 又是个找规律的
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		cin.nextLine();
		
		for(int i=0;i<N;i++){
			String str = cin.nextLine();
 
			char c[] = str.toCharArray();
			
			int Psize=0,Tsize=0,Apresize=0,Acentersize=0,Aendsize=0;
			
			int Pposition=0,Tposition=0;
			
			boolean flag = false;
			for(int j=0;j<c.length;j++){
				
				if(c[j]!='A'&&c[j]!='P'&&c[j]!='T'){
					System.out.println("NO");
					flag = true;
					break;
					 
				}
				if(c[j]=='P'){
					Psize++;
					Pposition = j;
				}
				if(c[j]=='T'){
					Tsize++;
					Tposition = j;
				}
			}
			if(flag==true)
				continue;
			
			if(Pposition+1==Tposition){
				System.out.println("NO");
				continue;
			}else if(Pposition>Tposition){
				System.out.println("NO");
				continue;
			}else if(Psize==1&&Tsize==1){
				String pre;
				if(Pposition==0){
					pre = "";
				}else{
					pre = str.substring(0,Pposition);
				}
				
				String center = str.substring(Pposition+1,Tposition);
				String end;
				if(Tposition==str.length()-1){
					end = "";
				}else{
					end = str.substring(Tposition+1);
				}
				Apresize = pre.length();
				Acentersize = center.length();
				Aendsize = end.length();
				if(Apresize*Acentersize==Aendsize){
					System.out.println("YES");
					continue;
				}else{
					System.out.println("NO");
					continue;
				}
				
			}else{
				System.out.println("NO");
			}
			
			
			
		}
	}

}
