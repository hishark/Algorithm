package test;

import java.util.Scanner;
//深度优先搜索DFS DFS素数环问题
public class Main {
    // 素数打表,题目规定n最大20,所以只要到40即可
    public static int prime[] = { 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 };
    // 记录是否被访问
    public static int visited[] = new int[20];
    // 保存结果序列
    public static int result[] = new int[20];
    // 素数环的数字个数
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
                // 判断i这个数有没有访问过
                if (visited[i] == 0) {
                    // 没有访问过i且i和相邻的数加起来为素数
                    if (prime[i + result[num - 1]] == 1) {
                        // 标记i为已访问
                        visited[i] = 1;
                        // 放进结果数组
                        result[num] = i;
                        num++;
                        // num自增之后继续递归往下深搜
                        dfs(num);
                        // 这个时候递归回来啦，重新将i设置为未访问
                        visited[i] = 0;
                        // 搜完当前的num，自减回退，准备往另外一个结点深搜
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
            // 每个结果序列都从1开始
            result[0] = 1;
            // 从1开始深搜
            dfs(1);
            System.out.println();
            cases++;
        }
    }
}