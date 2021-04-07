// 分治算法 递归
class Solution {
    public double myPow(double x, int n) {
        /**
         * 求 x ^ n
         * n 的范围是 [−2^31, 2^31 − 1] 即 int 的范围
         * 但是 -n 操作会导致越界，所以需要将 n 转换成 long 类型来计算
         */
        long N = n;
        
        // 下面3个N别不小心写成n啦
        if (N < 0) {
            return 1 / myPow(x, -N);
        }
        return myPow(x, N);
    }

    public double myPow(double x, long n) {
        // 边界处理
        if (n == 0 || x == 1) 
            return 1;

        // 奇偶次幂分别处理
        // 偶次幂
        if (n % 2 == 0) {
            double square = myPow(x, n / 2);
            return  square * square;
        } else {
            // 奇次幂
            double square = myPow(x, (n - 1) / 2); // 这里 n/2 也是一样的，重点在return的不同
            return square * square * x;
        }
    }
}

// 非递归，快速幂方法
class Solution {
    public double myPow(double x, int n) {
        /**
         * 求 x ^ n
         * n 的范围是 [−2^31, 2^31 − 1] 即 int 的范围
         * 但是 -n 操作会导致越界，所以需要将 n 转换成 long 类型来计算
         */
        long N = n;

        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        /**
         * 把指数 n 看成二进制数，比如 11 的二进制为 1011
         * 11 = 1*2^3 + 0*2^2 + 1*2^1 + 1*2^0
         * x^11 = x^(2^3) * x^(2^1) * x^(2^0)
         */
        double ans = 1;
        // 指数不为0
        while (N > 0) {
            // 将N转换为二进制数，从最低位开始
            // 如果当前位的二进制为1，那么就需要给 ans 乘上当前的 x
            if (N % 2 == 1) {
                ans *= x;
            }

            // x每一轮循环都要通过累乘来增加
            x *= x; // 假设 x 的初始值为3，那么x的值为：3^(2^0), 3^(2^1), 3^(2^2) ...
            // 解决完当前二进制位，将 N/2 继续求下一位
            N /= 2;
        }
        return ans;
    }
}

// 智障方法超时了兄弟
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
// ref: Krahets
class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
