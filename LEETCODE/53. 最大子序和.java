//暴力
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

//DP
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len==0)
            return 0;
        
        int[] dp = new int[len];//dp[i]表示到nums[i]为止的最大子序列和
        dp[0] = nums[0];
        
        for(int i=1;i<len;i++){
            if(dp[i-1]>=0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
        }
        
        //找出最大的子序列和
        int max = dp[0];
        for(int i=1;i<len;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        
        return max;
    }
}
