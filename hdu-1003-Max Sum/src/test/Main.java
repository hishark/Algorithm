package test;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	/*
	 * ��̬�滮����������к�
              ��Ϊ��Ŀ�и����ķ�Χ��-1000 ��1000�����������ʼ��maxsum��ʼ��Ϊ-1001 ��ֻ�б����п��ܵ�ֵ��Сʱ���С�
              ���maxsum��ʼ��Ϊ0����ô������ȫ�Ǹ���ʱ���ó������ֵ����0�����wrong�ˡ�
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