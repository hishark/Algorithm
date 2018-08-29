package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        int a, b;
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNextInt()) {
            a = inScanner.nextInt();
            b = inScanner.nextInt();
            System.out.println(a + b);
        }
    }

}
