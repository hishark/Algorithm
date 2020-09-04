// 超时了兄弟 不想做了明天再来看嘻嘻
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 1)
            return 1;
            
        double res = x;
        int preN = n;
        if (n < 0)
            n = -n;
        while (n != 1) {
            res *= x;
            n--;
        }
        return preN < 0 ? 1/res : res;
    }
}