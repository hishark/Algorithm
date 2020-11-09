// ref: https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
class Solution {
    public String minNumber(int[] nums) {
        // 把整数数组转换为字符串数组
        String[] strs = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        /**
         * Arrays.sort默认是对元素进行从小到大的排序
         * 修改排序规则如下，仍是从小到大进行排序，但是比较的不是 x 和 y
         * 而是 x + y 和 y + x
         *  1. x + y < y + x 时表示 x < y，x 排在 y 之前
         *  2. x + y > y + x 时表示 x > y，x 排在 y 之后
         */
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        
        // 把排序后的字符串数组拼接成结果字符串
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            res.append(str);
        }
        return res.toString();
    }
}