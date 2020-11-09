class Solution {
    public int[] singleNumbers(int[] nums) {
        // ^ 异或
        // A ^ A = 0
        // 0 ^ B = B

        // 先对所有数字进行一次异或
        // 可以得到两个只出现一次的数字的异或值
        // 假设两个数字为 resA 和 resB，那么 allXOR = resA ^ resB
        int allXOR = 0;
        for (int num : nums)
            allXOR ^= num;

        // 在 allXOR 中随便找出一个二进制中值为 1 的位
        // 该位为 1 说明 resA 和 resB 在这一位上对应的值不同
        // 该位为 0 说明 resA 和 resB 在这一位上对应的值相同
        // 而我们想找的就是不同的，所以找值为 1 的位
        int div = 1;
        while ((div & allXOR) == 0)
            div <<= 1; // 左移一位

        // 两个只出现一次的数字
        int resA = 0;
        int resB = 0;
        // 根据找到的 div 对所有数字进行分组
        // 在每个组内进行异或操作，分别可以得到只出现一次的数字：resA resB
        for (int num : nums)
            if ((div & num) == 0)
                resA ^= num;
            else
                resB ^= num;
        // 返回两个数字即可
        return new int[] { resA, resB };
    }
}