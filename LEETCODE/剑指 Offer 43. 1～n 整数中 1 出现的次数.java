// ref: https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
class Solution {
    public int countDigitOne(int n) {
        // digit 是「位因子」
        int digit = 1;
        int ans = 0;

        // 当前位
        int cur = n % 10;
        // cur之前的所有高位
        int high = n / 10;
        // cur之后会的所有低位
        int low = 0;

        // 从最低位一直循环遍历到最高位
        while (high != 0 || cur != 0) {
            // cur为0时，结果只由高位决定，为什么呢，看k佬，找规律太难了555
            if (cur == 0)
                ans += high * digit;
            // cur为1时，结果由高低位一起决定
            else if (cur == 1)
                ans += high * digit + low + 1;
            // cur为其他数字时，结果只由高位决定
            else 
                ans += (high + 1) * digit;

            // 更新cur hight low
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ans;
    }
}