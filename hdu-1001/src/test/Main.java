package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println(sum);
            System.out.println();
        }
    }
	/*
	 * ֱ����n*(n+1)/2�����
	      ����ж�����ż���ٽ�����;�ûë��
	      �Ǹɴ�ֱ��ѭ�������
	 */

}
