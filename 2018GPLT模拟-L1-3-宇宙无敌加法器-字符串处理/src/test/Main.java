package test;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * debug太有趣啦！
 */

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		String s = cin.nextLine();
		String s1 = cin.nextLine();
		String s2 = cin.nextLine();

		
		/*
		 * 如果输入的两个数不足N位，就在前方补满0
		 */
		String ss1 = "";
		for (int i = 0; i < s.length() - s1.length(); i++) {
			ss1 += "0";
		}
		String ss2 = "";
		for (int i = 0; i < s.length() - s2.length(); i++) {
			ss2 += "0";
		}
		s1 = ss1 + s1;
		s2 = ss2 + s2;

	 
		//carry是进位 
		int carry = 0;
		
		//这个list用来存逆序的计算结果
		ArrayList<String> result = new ArrayList<String>();

		for (int i = s.length() - 1; i >= 0; i--) {
			//确定是按照多少进制计算
			int mod = s.charAt(i) == '0' ? 10 : (s.charAt(i) - '0');
			 
			//temp是上下两个数字从后往前每两位的计算结果
			String temp = (s1.charAt(i) - '0' + s2.charAt(i) - '0' + carry) % mod + "";
			result.add(temp);
			
			//进位直接/就可以啦
			carry = (s1.charAt(i) - '0' + s2.charAt(i) - '0' + carry) / mod;
			 
		}
		
		//这个list用来存正序的计算结果
		ArrayList<String> result1 = new ArrayList<String>();
		
		/*
		 * 判断有没有进位
		 * 如果有进位就在最前面加一个1
		 * 而且要
		 */
		if (carry != 0) {
			result.add(0, "1");
			result1.add(result.get(0));
			for (int i = result.size() - 1; i > 0; i--) {
				result1.add(result.get(i));
			}
		}else{
			for (int i = result.size() - 1; i >= 0; i--) {
				result1.add(result.get(i));
			}
		}
		
		
		//用来标记是否有输出
		int flag = 0;

		for (int i = 0; i < result1.size(); i++) {
			/*
			 * 如果最后的结果前方有0，那肯定只有一个0
			 * 所以只要保证第一个0不输出，之后的数全部输出即可
			 * 所以flag==1之后一直输出
			 */
			if (!result1.get(i).equals("0") || flag == 1) {
				flag = 1;
				System.out.print(result1.get(i));
			}
		}
		
		/*
		 * 如果一次都没有输出，最后要输出一个0
		 */
		if (flag == 0)
			System.out.print(0);
		
	}
}
