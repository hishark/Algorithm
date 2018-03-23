package test;

  
import java.util.Scanner;
/*
 * 去PAT提交看运气啦
 * 有时候全超时
 * 有时候拿个17分
 * 就很神奇哈哈哈哈哈
 * 比赛的时候要多提交几次
 * 超时不超时
 * 看命看命
 * 
 * 
 * 这个题解我感觉是暴力吧
 * 纯枚举了
 */
public class Main {
	
	
	public static void main(String[] args){
		 
		Scanner cin =new Scanner(System.in);
	
		String str = cin.nextLine();
		
		int len = str.length();
		int max = 0;
		
		for(int i=0;i<len;i++){
			
			/*
			 * 回文串长度为奇数时，以i为对称轴，所以x初始值为1
			 * right和left见名知意啦
			 */
			int x = 1;
			int right = i+1;
			int left = i-1;
			while(right<len&&left>=0){
				if(str.charAt(right) == str.charAt(left)){
					right++;
					left--;
					x+=2;
				}else{
					break;
				}
			}
			
			//更新max的值
			max = Math.max(max, x);
			
			/*
			 * 回文串长度为偶数时，就不存在对称轴了，所以x初始值为0
			 */
			x = 0;
			right = i+1;
			left = i;
			
			while(right<len&&left>=0){
				if(str.charAt(right)==str.charAt(left)){
					x+=2;
					right++;
					left--;
				}else{
					break;
				}
			}
			max = Math.max(max, x);
		}
		
		
		System.out.println(max);
		
	}
	
	
	
}
 
