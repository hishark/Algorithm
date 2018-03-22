package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
 * 第一次该进算法哈哈哈哈哈哈哈哈开开心心
 * 这个方法超级好
 * 虽然超时了没关系
 * 算法是没问题滴！
 */
public class Main {
	 
	public static void main(String[] args){
		Scanner cin =new Scanner(System.in);
		int start = cin.nextInt();
		int N = cin.nextInt();
		 
		/*
		 * 开两个集合
		 * 一个存要留下的节点
		 * 一个存要删除的节点
		 * 不过要注意
		 * 这些节点的add是按顺序排列的
		 * 但是next已经乱了
		 * 等两个集合确定之后把next调整一下就好啦！
		 */
		ArrayList<Node> remain = new ArrayList<Node>();
		ArrayList<Node> delete = new ArrayList<Node>();
		
		Node node[] = new Node[100000];
		
		for(int i=0;i<N;i++){
			boolean isIn = false;
			String address = cin.next();
			node[Integer.parseInt(address)] = new Node();
			node[Integer.parseInt(address)].add = address;
			node[Integer.parseInt(address)].key = cin.nextInt();
			node[Integer.parseInt(address)].next = cin.next();
		}
 
		//判断一个值是否已经存在!exists[100]=true就表示100存在啦！
		boolean exists[] = new boolean[100000];
 
		for(int i=start;i!=-1;i=Integer.parseInt(node[i].next)){
			 if(exists[Math.abs(node[i].key)]==false){
				 exists[Math.abs(node[i].key)] = true;
				 remain.add(node[i]);
			 }else{
				 delete.add(node[i]);
			 }
		}
		
		/*
		 * 把next调整一下就好啦
		 */
		for(int i=0;i<remain.size()-1;i++){
			remain.get(i).next = remain.get(i+1).add;
		}
		remain.get(remain.size()-1).next="-1";
		
		/*
		 * 这里一定要记得判断delete是否为空
		 * 为空就不存在调整的问题啦
		 */
		if(delete.size()!=0){
			for(int i=0;i<delete.size()-1;i++){
				delete.get(i).next = delete.get(i+1).add;
			}
			delete.get(delete.size()-1).next="-1";
		}
		
		
		for(int i=0;i<remain.size();i++){
			System.out.println(remain.get(i).add+" "+remain.get(i).key+" "+remain.get(i).next);
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