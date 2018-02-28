package test;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int up = 6, down = 4, stay = 5, curFloor = 0;
        int N = cin.nextInt();
        while (N != 0) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int goalFloor = cin.nextInt();
                if (goalFloor > curFloor) {
                    sum = sum + (goalFloor - curFloor) * up;
                } else {
                    sum = sum + (curFloor - goalFloor) * down;
                }
                sum += stay;
                curFloor = goalFloor;
            }
            System.out.println(sum);
            curFloor = 0;
            N = cin.nextInt();
        }
    }
}