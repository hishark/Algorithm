package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        while (N != 0) {
            ArrayList<String> ballon = new ArrayList<String>();
            for (int i = 0; i < N; i++) {
                ballon.add(cin.next());
            }
            int count[] = new int[N];
            for (int i = 0; i < N; i++) {
                count[i] = 0;
            }
            for (int i = 0; i < N; i++) {
                String s = ballon.get(i);
                for (String test : ballon) {
                    if (s.equals(test)) {
                        count[i]++;
                    }
                }
            }
            int max = count[0], maxLoc = 0;
            // 此时count存下了每个字符串出现的次数
            for (int i = 1; i < N; i++) {
                if (count[i] > max) {
                    max = count[i];
                    maxLoc = i;
                }
            }
            // max此时存下了最大的count
            System.out.println(ballon.get(maxLoc));
            N = cin.nextInt();
        }
    }
}