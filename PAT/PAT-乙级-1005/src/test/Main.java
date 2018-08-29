package test;

 
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Student stu[] = new Student[n];
		for(int i=0;i<n;i++){
			stu[i] = new Student(cin.next(),cin.next(),cin.nextInt());
		}
		Arrays.sort(stu);
		System.out.println(stu[stu.length-1].name+" "+stu[stu.length-1].sno);
		System.out.println(stu[0].name+" "+stu[0].sno);
		
	}

}
class Student implements Comparable<Student>{
	String name;
	String sno;
	int grade;
	
	Student(String a,String b,int c){
		name = a;
		sno = b;
		grade = c;
		
	}

	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		 
		return (grade>arg0.grade)?1:-1;
	}
}
