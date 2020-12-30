class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 当前手中持有的 5 美元钞票的张数
        int five = 0;
        // 当前手中持有的 10 美元钞票的张数
        int ten = 0;
        // 遍历账单
        for (int bill : bills) {
            // 碰到了最喜欢的 5 美元钞票，无需找零，计数即可
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                // 碰到了 10 美元，需要找 5 美元
                if (five == 0) {
                    // 如果没得找，直接返回 false
                    return false;
                }
                // 如果有 5 美元的钞票就找给客人，然后减少数量
                five--;
                // 别忘记此时还的得到了一张 10 美元的钞票
                ten++;
            } else {
                // 碰到了最烦人的 20 美元
                if (five > 0 && ten > 0) {
                    // 如果 5 和 10 都有，皆大欢喜
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // 如果有三张 5 美元的，也可以找回
                    // 使用到 5 美元的场景更多所以 10+5 的找钱方案优先，三个 5 的方案靠后
                    five -= 3;
                } else {
                    // 以上都没有，直接返回 false
                    return false;
                }
            }
        }
        // 遍历完所有的账单都成功找回了，返回 true
        return true;
    }
}

// ref：https://leetcode-cn.com/problems/lemonade-change/solution/ning-meng-shui-zhao-ling-by-leetcode-sol-nvp7/