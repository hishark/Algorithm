class Solution {
    public int add(int a, int b) {
        /**
         * 「无进位和」和「异或运算」规律相同
         * 「进位」和「与运算」规律相同，并需要左移一位
         *  注：
         *  1. 异或运算：两个位相同为 0，相异为 1
         *  2. 与运算：两个位都为 1时，结果才为 1
         */
        // 进位为 0 时结束循环♻️
        while (b != 0) {
            // 进位
            int carry = (a & b) << 1;
            a ^= b; // a 是「无进位和」
            b = carry; // b 是「进位」
        }
        return a;
    }
}