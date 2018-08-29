package test;

 
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		ArrayList<String> s = new ArrayList<String>();
		for(int i=0;i<N;i++){
			int num = cin.nextInt();
			if(num==1)
				cin.next();
			else{
				for(int j=0;j<num;j++){
					String input = cin.next();
					s.add(input);
				}
			}
		}
		
		 
		
		ArrayList<String> result = new ArrayList<String>();
		
		int M = cin.nextInt();
		boolean isFirst = true;
		for(int i=0;i<M;i++){
			String input = cin.next();
			boolean isIn = false;
			
			for(int j=0;j<s.size();j++){
				if(s.get(j).equals(input)){
					 
					isIn = true;
					break;
				}
			}
			
			if(isIn==false){
				boolean isPrint = false;
				
				for(int j=0;j<result.size();j++){
					if(result.get(j).equals(input)){
						isPrint = true;
						break;
					}
				}
				
				if(isPrint==false){
					if(isFirst){
						System.out.print(input);
						isFirst = false;
					}else{
						System.out.print(" "+input);
					}
					result.add(input);
				}
				
			}
			
			
		}
		
		if(result.size()==0)
			System.out.println("No one is handsome");
	}
}