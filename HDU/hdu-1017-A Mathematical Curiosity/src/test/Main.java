package test;

import java.util.Scanner;
/*
 * 给你数n,找出两个数a,b，0 < a < b < n,满足(a^2+b^2 +m)%(ab)==0，输出有多少个这样的ab组合
16行用Math.pow就超时
正常使用是没毛病的
这里是因为用了暴力枚举
当a和b的值太大的时候
就会出现超时问题啦
换成a*a+b*b就成功AC了！
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
