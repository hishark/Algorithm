package test;

 
import java.util.ArrayList;
import java.util.Arrays;
 
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
 
public class Main {
	//判断是否是镜像二叉搜索树（即左大右小咯），默认为false
	static boolean isMirror;
	
	//存前序遍历
	static ArrayList<Integer> pre = new ArrayList<Integer>();
	
	//存后序遍历
	static ArrayList<Integer> post = new ArrayList<Integer>();
	
	public static void main(String[] args){
		 
		Scanner cin =new Scanner(System.in);
		
		//结点数
		int N = cin.nextInt();
		
		/*
		 * 假设是一颗二叉搜索树
		 * 输入即前序遍历
		 */
		for(int i=0;i<N;i++){
			int input = cin.nextInt();
			pre.add(input);
		}
		
		/*
		 * 得到后序遍历
		 */
		getpost(0, N-1);
		
		/*
		 * 得到后序遍历之后
		 * 判断这个树是不是镜像的 
		 * 如果不等于N就是镜像的二叉搜索树
		 */
		if(post.size()!=N){
			isMirror = true;
			post.clear();
			getpost(0, N-1);
		}
		
		if(post.size()==N){
			System.out.println("YES");
			System.out.print(post.get(0));
			for(int i = 1; i < N; i++)
	            System.out.print(" "+post.get(i));
		}else{
			System.out.println("NO");
		}
	
	}
	
	public static void getpost(int root,int tail){
		
		if(root>tail)
			return;
		int i = root + 1, j = tail;
		
		/*
		 * 如果不是镜像就找到一个比根节点大的i 比根节点小的j
		 */
		if(!isMirror){
			while(i<=tail && pre.get(root)>pre.get(i))
				i++;
			while(j>root && pre.get(root)<=pre.get(j))
				j--;
		}else{
			//如果是镜像的就和上面相反
			
			while(i<=tail && pre.get(root)<=pre.get(i))
				i++;
			while(j>root && pre.get(root)>pre.get(j))
				j--;
		}
		
		/*
		 * i大于根节点
		 * j小于根节点
		 * 一旦i和j相邻，就表示啥哦？？
		 * 应该是这个序列本身就是前序遍历的意思吧？
		 * 
		 */
		if(i-j!=1)
			return;
		
		//j节点比根节点小 就作为左子树的根 继续递归得到一个后序
		getpost(root+1, j);
		
		//i节点比根节点大 就作为右子树的根 继续递归得到一个后序
		getpost(i, tail);
		
		//一个个把根节点加入到post 也就是后序序列
		post.add(pre.get(root));
	}
	
}
 
