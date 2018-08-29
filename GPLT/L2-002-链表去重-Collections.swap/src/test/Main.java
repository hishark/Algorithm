package test;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;
 
public class Main {
	 
	public static void main(String[] args){
		Scanner cin =new Scanner(System.in);
		int start = cin.nextInt();
		int N = cin.nextInt();
		ArrayList<Node> al = new ArrayList<Node>();
		ArrayList<Node> delete = new ArrayList<Node>();
		for(int i=0;i<N;i++){
			boolean isIn = false;
			Node a = new Node();
			a.add = cin.next();
			a.key = cin.nextInt();
			a.next = cin.next();
			
			 for(int j=0;j<al.size();j++){
				if(Math.abs(a.key)==Math.abs(al.get(j).key)){
					isIn = true;
					break;
				}
				
					
			}
			if(isIn)
				delete.add(a);
			else{
				if(Integer.parseInt(a.add)==start){
					al.add(0, a);
				}else{
					al.add(a);
				}
				
			}
				
			
		}
 
	 
	 
		for(int i=0;i<al.size()-1;i++){
			for(int j=1;j<al.size()-i-1;j++){
				if(Integer.parseInt(al.get(j).add)>Integer.parseInt(al.get(j+1).add)){
					Collections.swap(al, j, j+1);
				}
			}
		}
		
	
		
		
		for(int i=0;i<delete.size()-1;i++){
			for(int j=0;j<delete.size()-i-1;j++){
				if(Integer.parseInt(delete.get(j).add)>Integer.parseInt(delete.get(j+1).add)){	  
					Collections.swap(delete, j, j+1);
				}
			}
		}
		
		 
		 
	 
		for(int i=0;i<al.size()-1;i++){
			al.get(i).next = al.get(i+1).add;
		}
		al.get(al.size()-1).next="-1";
		
		if(delete.size()!=0){
			for(int i=0;i<delete.size()-1;i++){
				delete.get(i).next = delete.get(i+1).add;
			}
			delete.get(delete.size()-1).next="-1";
		}
		
		
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i).add+" "+al.get(i).key+" "+al.get(i).next);
		}
		
		 
		for(int i=0;i<delete.size();i++){
			System.out.println(delete.get(i).add+" "+delete.get(i).key+" "+delete.get(i).next);
		}
		 
		 
	}
	
	
}

class Node{
	String add;
	int key;
	String next;
	 
}