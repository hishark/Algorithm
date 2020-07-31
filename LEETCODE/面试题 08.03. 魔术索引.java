// 今天放假 水一下 下次看看二分咋做
class Solution {
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i)
                return i;
        }
        return -1;
    }
}
