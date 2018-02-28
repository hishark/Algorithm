package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/*
	 * �����������ҳ�ѭ����
              ��Ϊf(n)�Ľ����ģ7�ģ���ôf(n)�Ľ��ֻ������{0,1,2,3,4,5,6,}�У�����f(n)��f(n-1)�Ľ��ֻ������7*7 = 49�֣��������������ԣ�����Դ����߳�������ʱ�䡣
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
 * ���Լ������õݹ�д
          ���Memory Limit Exceede
          �ݹ�̫���ڴ���
 
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