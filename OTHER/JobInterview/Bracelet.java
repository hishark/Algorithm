package ByteDanceInterview;

import java.util.Scanner;

/** 
 * @author hishark
 * �ִ�����
 * ��Ŀ����https://www.nowcoder.com/test/8537261/summary
 * ͬ���Ĵ�����ʱ��100%ͨ����ʱ��80%ͨ����ʱ��70%ͨ����(���� ��)�� �㷨���ܻ���������
 */
public class Bracelet {

	public static void main(String[] args) {
		// n-�������� m-�������ӵĸ��� c-��ɫ����
		int n,m,c;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		c = cin.nextInt();
		//���������ڴ�ÿһ�����ӵ���ɫ a[i]�ͱ�ʾ��i�����ӵ�������ɫ
		int a[][] = new int[n][c];
		for(int i=0;i<n;i++) {
			int num;
			num = cin.nextInt();
			for(int j=0;j<num;j++) {
				a[i][j] = cin.nextInt();
			}
		}
		int result = 0;
		//��Բ�ͬ����ɫ���ж�
		for(int i=0;i<c;i++) {
			//��newһ��b���飬���ڴ����������Ƿ���ڵ�ǰ�����ɫ
			int b[] = new int[n];
			for(int j=0;j<n;j++) {
				for(int k=0;k<c;k++) {
					if(a[j][k]==i+1) {
						b[j]=1;//Ϊ1��ʾ���ڸ���ɫ
					}
				}
			}
			
			//��ʼ��ÿһ�����ӿ�ʼ���б����ж�
			for(int x=0;x<n;x++) {
				//ÿ�ж�һ�Ŷ�Ҫcount=0������д��������ɵ��
				int count = 0;
				for(int y=x;y<x+m;y++) {
					if(b[y%n]==1) {
						count++;
					}
				}
				if(count>1) {
					result++;
					//����break�˿��Լ��ټ����������ǲ�breakҲû��ʲôӰ�죬�������ΰ���
					break;
				}
			}
		}
		System.out.println(result);
		
		
	}

}
