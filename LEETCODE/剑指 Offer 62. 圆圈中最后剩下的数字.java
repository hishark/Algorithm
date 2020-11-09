//ref: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-by-lee/
//https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
// 递归
class Solution {
    public int lastRemaining(int n, int m) {
        return recursion(n, m);
    }

    // 该函数返回的是最终留下的元素序号
    public int recursion(int n, int m) {
        // 递归出口
        if (n == 1)
            return 0;

        // 假设长度为 n - 1 的序列最终留下的元素序号为 x
        int x = recursion(n - 1, m);

        // 知道上一个序列最后留下的元素序号，就可以往后移 m 位求出当前序列
        return (m + x) % n;
    }
}

// 约瑟夫环问题
class Solution {
    public int lastRemaining(int n, int m) {
        int res = 0;
        // 最后一轮只剩下两个人，所以从 2 开始反推
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}