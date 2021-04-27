// 递归会超时


class Solution {
    public int fib(int n) {
        if (n==0 || n==1)
            return n;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i=2;i<=n;i++)
            res[i] = (res[i-1] + res[i-2]) % 1000000007;
        return res[n];
    }
}