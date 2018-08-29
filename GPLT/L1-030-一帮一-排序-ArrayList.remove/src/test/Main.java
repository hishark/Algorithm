package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();

		ArrayList<Student> stu = new ArrayList<Student>();
		for(int i=0;i<N;i++){
			Student s = new Student(cin.nextInt(),cin.next());
			stu.add(s);
		}
		
		int i=0,j=N-1;
		
		while(i<stu.size()&&j>=0){

			while(stu.get(i).sex==stu.get(j).sex){
				j--;
			}
			System.out.println(stu.get(i).name+" "+stu.get(j).name);
		 
			
			stu.remove(i);
			//删掉i之后总数少了一个啦 所以j一定要记得减1哦
			stu.remove(j-1);
			
			int length = stu.size();
	 
			j = length - 1;
			i = 0;
		}
	}
	
	 
}
class Student{
	int sex;
	String name;
	Student(int a,String b){
		sex = a;
		name = b;
	}
}
 