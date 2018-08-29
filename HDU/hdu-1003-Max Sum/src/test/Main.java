package test;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	/*
	 * 动态规划求最大子序列和
              因为题目中给出的范围是-1000 ～1000，所以这里初始的maxsum初始化为-1001 ，只有比所有可能的值都小时才行。
              如果maxsum初始化为0，那么当序列全是负数时，得出的最大值将是0，这就wrong了。
	 */
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int casenum = cin.nextInt();
        int input;
        for (int i = 1; i <= casenum; i++) {
            int number = cin.nextInt();
            int sum = 0, maxsum = -1001, temp = 1, first = 1, last = 1;
            for (int j = 1; j <= number; j++) {
                input = cin.nextInt();
                sum += input;
                if (sum > maxsum) {
                    first = temp;
                    last = j;
                    maxsum = sum;
                }
                if (sum < 0) {
                    temp = j + 1;
                    sum = 0;
                }
            }
            System.out.println("Case " + i + ":");
            System.out.println(maxsum + " " + first + " " + last);
            if (i != casenum) {
                System.out.println();
            }
        }
    }
}