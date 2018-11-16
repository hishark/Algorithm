package ByteDanceInterview;

import java.util.*;
/**
 * 
 * @author hishark
 * 用户喜爱
 * 题目链接https://www.nowcoder.com/test/8537261/summary
 * 通过率100%
 */
public class UserLike {
	public static HashMap<Integer,Node> hashMap = new HashMap<>();

	static class Node{
		int position;
		Node next;
		public Node(int position){
			this.position = position;
		}
		public void addNode(Node node) {
			if(this.next==null) {
				this.next = node;
			}else {
				this.next.addNode(node);
			}
		}
	}
	
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        int n;
        n = cin.nextInt();
        for(int i=1;i<=n;i++) {
        	int like;
        	like = cin.nextInt();
        	Node node = new Node(i);
        	//判断hashMap中存不存在当前喜爱值，不存在就添加为头结点，存在就添加在单链表尾巴上
        	if(hashMap.get(like)==null) {
        		hashMap.put(like, node);
        	}else {
        		hashMap.get(like).addNode(node);
        	}
        	
        }
        
        int searchNum;
        searchNum = cin.nextInt();
        for(int i=0;i<searchNum;i++) {
        	int result=0;
        	int left, right, k;
        	left = cin.nextInt();
        	right = cin.nextInt();
        	k = cin.nextInt();
        	
        	//拿到喜爱值为k的根结点
        	Node root = hashMap.get(k);
        	while(root!=null&&root.position<=right) {
        		if(root.position<=right&&root.position>=left) {
        			result++;
        		}
        		root = root.next;
        	}
        	System.out.println(result);
        }
        
    }
}
 