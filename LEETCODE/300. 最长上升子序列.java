class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //dp[i]表示前i个数字中，以nums[i]结尾的，必须选上nums[i]的最长子序列的长度。
        int[] dp = new int[nums.length];
        dp[0]=1;
        int maxLength=1;
        
        for(int i=1;i<nums.length;i++){
            int maxBefore=0;//i之前的最大dp值
            //内for循环用于求出0～j之间的最大dp值---maxBefore
            for(int j=0;j<i;j++){
                //当且仅当nums[i]大于之前的某个nums[j]，才需要更新maxBefore
                if(nums[i]>nums[j]){
                    maxBefore = Math.max(maxBefore, dp[j]);
                }
            }
            //求出maxBefore以后，再算dp[i].
            //maxBefore=0意味着，在i之前，没有比nums[i]还小的数字，所以dp[i]就为1.
            dp[i] = maxBefore+1;
            //每循环一次就比较一下，存下最大dp值
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}