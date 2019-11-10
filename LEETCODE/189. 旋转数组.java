//空间O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] newNums = new int[len];
        
        for(int i=0;i<len;i++){
            newNums[(i+k)%len] = nums[i];
        }
        for(int i=0;i<len;i++){
            nums[i] = newNums[i];
        }
    }
}

//空间O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;//☆☆☆
        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
    }
    
    public void reverse(int[] nums, int begin, int end){
        while(begin < end){
            //双指针
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
