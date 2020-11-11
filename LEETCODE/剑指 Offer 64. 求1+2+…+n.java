class Solution {
    public int sumNums(int n) {
        /**
         * A && B
         * A: n > 0
         * B: n += sumNums(n - 1)
         * 可以将判断是否为递归的出口看作 A 部分
         * 将递归的主体函数看作 B 部分
         *  1. 如果不是递归出口，也就是 n > 0，那么返回 True，继续执行 B 部分，进行递归
         *  2. 如果是递归出口，也就是 n == 0，那么返回 False，短路，不再执行 B 部分，结束递归
         */
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}