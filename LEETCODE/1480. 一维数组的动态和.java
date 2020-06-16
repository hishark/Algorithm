class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<res.length;i++) {
            res[i] = res[i-1] + nums[i];
        }
        return res;
    }
}