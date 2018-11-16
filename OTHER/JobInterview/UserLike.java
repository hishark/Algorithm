package ByteDanceInterview;

import java.util.*;
/**
 * 
 * @author hishark
 * �û�ϲ��
 * ��Ŀ����https://www.nowcoder.com/test/8537261/summary
 * ͨ����100%
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
        	//�ж�hashMap�д治���ڵ�ǰϲ��ֵ�������ھ����Ϊͷ��㣬���ھ�����ڵ�����β����
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
        	
        	//�õ�ϲ��ֵΪk�ĸ����
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
 