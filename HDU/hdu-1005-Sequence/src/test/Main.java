package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/*
	 * 利用周期性找出循环节
              因为f(n)的结果是模7的，那么f(n)的结果只可能在{0,1,2,3,4,5,6,}中，这样f(n)与f(n-1)的结果只可能是7*7 = 49种，合理利用周期性，便可以大大提高程序运行时间。
	 */
	// f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
	// f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
    static int A, B;
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        A = cin.nextInt();
        B = cin.nextInt();
        int n = cin.nextInt();
        while (A != 0 && B != 0 && n != 0) {
            System.out.println(fa(n));
            A = cin.nextInt();
            B = cin.nextInt();
            n = cin.nextInt();
        }
    }
    public static int fa(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return (A * fa(n - 1) + B * fa(n - 2)) % 7;
        }
    }
}

/*
 * 先自己试了用递归写
          结果Memory Limit Exceede
          递归太耗内存啦
 
public class Main {
    // f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
    static int A, B;
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        A = cin.nextInt();
        B = cin.nextInt();
        int n = cin.nextInt();
        while (A != 0 && B != 0 && n != 0) {
            System.out.println(fa(n));
            A = cin.nextInt();
            B = cin.nextInt();
            n = cin.nextInt();
        }
    }
    public static int fa(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return (A * fa(n - 1) + B * fa(n - 2)) % 7;
        }
    }
}
*/