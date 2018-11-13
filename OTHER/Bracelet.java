package ByteDanceInterview;

import java.util.Scanner;

/** 
 * @author hishark
 * 手串问题
 * 题目链接https://www.nowcoder.com/test/8537261/summary
 * 同样的代码有时候100%通过有时候80%通过有时候70%通过┑(￣Д ￣)┍ 算法可能还是有问题
 */
public class Bracelet {

	public static void main(String[] args) {
		// n-珠子数量 m-连续珠子的个数 c-颜色总数
		int n,m,c;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		c = cin.nextInt();
		//该数组用于存每一颗珠子的颜色 a[i]就表示第i颗珠子的所有颜色
		int a[][] = new int[n][c];
		for(int i=0;i<n;i++) {
			int num;
			num = cin.nextInt();
			for(int j=0;j<num;j++) {
				a[i][j] = cin.nextInt();
			}
		}
		int result = 0;
		//针对不同的颜色来判断
		for(int i=0;i<c;i++) {
			//先new一个b数组，用于存所有珠子是否存在当前这个颜色
			int b[] = new int[n];
			for(int j=0;j<n;j++) {
				for(int k=0;k<c;k++) {
					if(a[j][k]==i+1) {
						b[j]=1;//为1表示存在该颜色
					}
				}
			}
			
			//开始对每一颗珠子开始进行遍历判断
			for(int x=0;x<n;x++) {
				//每判断一颗都要count=0，这句别写在外面了傻仔
				int count = 0;
				for(int y=x;y<x+m;y++) {
					if(b[y%n]==1) {
						count++;
					}
				}
				if(count>1) {
					result++;
					//这里break了可以减少计算量，但是不break也没有什么影响，多算两次罢辽
					break;
				}
			}
		}
		System.out.println(result);
		
		
	}

}
