class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for(int i=0;i<nums.length;i++) {
            int res = nums[i];
            // 数组长度为1的情况别漏了
            if(res>max){
                max = res;
            }
            for(int j=i+1;j<nums.length;j++) {
                res = res * nums[j];
                if(res>max){
                    max = res;
                }
            }
        }
        return max;
    }                               
}