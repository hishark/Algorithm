package test;

import java.util.Scanner;
/*
 * ������n,�ҳ�������a,b��0 < a < b < n,����(a^2+b^2 +m)%(ab)==0������ж��ٸ�������ab���
16����Math.pow�ͳ�ʱ
����ʹ����ûë����
��������Ϊ���˱���ö��
��a��b��ֵ̫���ʱ��
�ͻ���ֳ�ʱ������
����a*a+b*b�ͳɹ�AC�ˣ�
 */
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int cases = 1;
            while (!(m == 0 && n == 0)) {
                int sum = 0;
                for (int a = 1; a < n; a++) {
                    for (int b = a + 1; b < n; b++) {
                        if ((a * a + b * b + m) % (a * b) == 0) {
                            sum++;
                        }
                    }
                }
                System.out.println("Case " + cases + ": " + sum);
                cases++;
                n = cin.nextInt();
                m = cin.nextInt();
            }
            if (i != N - 1)
                System.out.println();
        }
    }
}
