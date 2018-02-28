package test;

import java.util.Scanner;
//��������a��λ���й�ʽ
//��������һ��������a��λ��Ϊint(log10(a))+1
//��ô����A=n!=1*2*3*4*��*n��˵
//A��λ��Ϊint(log10(1*2*3*4*��*n))+1
//��int(log10(1)+log10(2)+...+log10(n))+1
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            int input = cin.nextInt();
            System.out.println(getDigits(input));
        }
    }
    // �õ�n!�����������λ��
    public static int getDigits(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.log10(i);
        }
        return (int)sum+1;
    }
}


//��BigInteger�����ȷ���ǻᳬʱ
/*import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for(int i=0;i<n;i++){
            //����n��������
            int input = cin.nextInt();
            System.out.println(getDigits(getJc(input)));
        }
    }
    public static BigInteger getJc(int n){
        BigInteger sum = BigInteger.valueOf(1);
        for(int i=2;i<=n;i++){
            BigInteger j = BigInteger.valueOf(i);
            sum = sum.multiply(j);
        }
        return sum;
    }
    //���������n��λ����
    public static int getDigits(BigInteger n){
        int number = 1;
        BigInteger div = BigInteger.valueOf(10);
        BigInteger zero = BigInteger.valueOf(0);
        while(n.divide(div)!=zero){
            number++;
            n=n.divide(div);
        }
        return number;
    }
}*/
