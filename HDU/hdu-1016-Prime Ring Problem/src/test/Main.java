package test;

import java.util.Scanner;
//�����������DFS DFS����������
public class Main {
    // �������,��Ŀ�涨n���20,����ֻҪ��40����
    public static int prime[] = { 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 };
    // ��¼�Ƿ񱻷���
    public static int visited[] = new int[20];
    // ����������
    public static int result[] = new int[20];
    // �����������ָ���
    public static int n;
    public static void dfs(int num) {
        if (num == n && prime[result[num - 1] + result[0]] == 1) {
            for (int i = 0; i < num; i++) {
                System.out.print(result[i]);
                if (i + 1 != num)
                    System.out.print(" ");
            }
            System.out.println();
        } else {
            for (int i = 2; i <= n; i++) {
                // �ж�i�������û�з��ʹ�
                if (visited[i] == 0) {
                    // û�з��ʹ�i��i�����ڵ���������Ϊ����
                    if (prime[i + result[num - 1]] == 1) {
                        // ���iΪ�ѷ���
                        visited[i] = 1;
                        // �Ž��������
                        result[num] = i;
                        num++;
                        // num����֮������ݹ���������
                        dfs(num);
                        // ���ʱ��ݹ�����������½�i����Ϊδ����
                        visited[i] = 0;
                        // ���굱ǰ��num���Լ����ˣ�׼��������һ���������
                        num--;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int cases = 1;
        while (cin.hasNext()) {
            n = cin.nextInt();
            System.out.println("Case " + cases + ":");
            // ÿ��������ж���1��ʼ
            result[0] = 1;
            // ��1��ʼ����
            dfs(1);
            System.out.println();
            cases++;
        }
    }
}