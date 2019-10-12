class Solution {
    public int maxSubArray(int[] nums) {
        int maxAns = nums[0];//结果
        int sum = 0;//当前最大连续子序列和
        for(int num: nums){
            if(sum>=0){
                sum += num;
            }else{
                sum = num;
            }
            maxAns = Math.max(maxAns, sum);//每算一次都要比较一下，取较大值
        }
        return maxAns;
    }
}
