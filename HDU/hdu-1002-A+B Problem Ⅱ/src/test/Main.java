package test;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        BigInteger a, b;
        int T;
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case" + " " + i + ":");
            a = in.nextBigInteger();
            b = in.nextBigInteger();
            if (i < T) {
                System.out.println(a + " + " + b + " = " + a.add(b));
                System.out.println();
            } else {
                System.out.println(a + " + " + b + " = " + a.add(b));
            }
        }
    }
	/*
	 * 大数求和 直接用BigInteger
              我爱java
	 */

}
