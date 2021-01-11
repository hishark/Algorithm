class Solution {
    // 从大到小遍历
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        // 最终结果
        StringBuilder res = new StringBuilder();
        // 从大到小遍历每一个符号，直到 num 变成 0
        for (int i = 0; i < values.length && num >= 0; i++) {
            // 当前罗马数字如果小于等于 num，就从 num 中减去当前罗马数字
            // 并且把该罗马数字加入到结果中
            while (values[i] <= num) {
                num -= values[i];
                res.append(symbols[i]);
            }
        }
        // 返回结果即可
        return res.toString();
    }
}

// ref：https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcode/