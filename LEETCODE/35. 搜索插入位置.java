class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        while (left <= right) {
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left++;
                mid = left + (right - left)/2;
            } else {
                right--;
                mid = left + (right - left)/2;
            }         
        }   

        return left;
    }
}
