//https://leetcode-cn.com/problems/the-masseuse-lcci/solution/100-kong-jian-cong-onyou-hua-dao-o1bao-hui-by-swee/
//甜姨稳👍
class Solution {
    public int massage(int[] nums) {
        int a=0, b=0;
        for (int i=0; i<nums.length; i++) {
            int c = Math.max(b, a+nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}

