package ByteDanceInterview;

import java.util.Scanner;
/**
 * 
 * @author hishark
 * ����
 * ��Ŀ����https://www.nowcoder.com/test/8537072/summary
 * ͨ����80%
 */
public class Room {

	public static void main(String[] args) {
		int n, k;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		k = cin.nextInt();
		int a[] = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = cin.nextInt();
		}
		// ��ȥ�˶�����
		int outPerson = 0;

		//����
		while(a[k]!=0) {
			a[k]--;
			outPerson++;
			
			//kΪ����� 
			k = (k - 1) % n;
			if (k == 0)
				k = n;
			
		}
		
		a[k] = outPerson;
		
		for(int i=1;i<=n;i++) {
			if(i!=n) {
				System.out.print(a[i]+" ");
			}else {
				System.out.print(a[i]);
			}
		}
		

	}

}
