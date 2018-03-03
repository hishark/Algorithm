package test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            double x = cin.nextDouble();
            System.out.printf("%.2f",Math.abs(x));
            System.out.println();
        }
    }

}
