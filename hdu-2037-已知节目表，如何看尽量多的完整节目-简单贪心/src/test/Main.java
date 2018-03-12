package test;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 感谢大哥！
 * http://www.ttwen.info/article/1116403
 * 解決思路：
	1.根據電視節目數n創建對應的n個節目對象，初始化其開始及結束時間
	2.將所有節目以結束時間升序排列
	3.當下一個節目開始時間大於當前節目的結束時間時，加入觀看的隊列
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			if (n == 0)
				break;
			else {
				TV tvs[] = new TV[n];
				for (int i = 0; i < n; i++) {
					/*
					 * 哇这句学到了 以后这么写
					 */
					tvs[i] = new TV(cin.nextInt(), cin.nextInt());
				}
				// 按结束时间升序排序
				Arrays.sort(tvs);
				/*
				 * 直接冒泡也ok啦
				 */
				/*
				 * for(int i=0;i<tvs.length-1;i++){ for(int
				 * j=0;j<tvs.length-i-1;j++){
				 * if(tvs[j].EndTime>tvs[j+1].EndTime){ TV temp = tvs[j]; tvs[j]
				 * = tvs[j+1]; tvs[j+1] = temp; } } }
				 */
				int k = 0;
				int sum = 0;
				for (int i = 0; i < n; i++) {
					if (tvs[i].StartTime >= k) {
						sum++;
						k = tvs[i].EndTime;
					}
				}
				System.out.println(sum);
			}
		}
	}

}

/*
 * Arrays.sort和Comparable结合起来厉害了哦
 */
class TV implements Comparable {

	int StartTime;
	int EndTime;

	public TV(int s, int e) {
		this.StartTime = s;
		this.EndTime = e;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		TV tv = (TV) o;
		return (EndTime > tv.EndTime) ? 1 : -1;
	}

}
