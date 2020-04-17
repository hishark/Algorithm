public class Solution {
    public boolean canJump(int[] nums) {
        int rightBorder = 0;
        int length = nums.length;
        for (int i=0;i<length;i++) {
            //如果当前位置小于最右边界，说明可以继续跳跃，于是就更新边界
            if(i<=rightBorder) {
                rightBorder = Math.max(rightBorder, i+nums[i]);

            }
            //最右边界超过了最后一个位置，一定可以到达终点，直接返回true。
            if(rightBorder >= length-1){
                return true;
            }
        }
        //找不到就返回false
        return false;
    }
}

