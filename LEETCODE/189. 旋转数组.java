//空间O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        // 数组长度
        int len = nums.length;
        // 新数组
        int[] newNums = new int[len];
        
        // 巧妙利用取模运算符
        for(int i=0;i<len;i++){
            newNums[(i+k)%len] = nums[i];
        }

        // 把新数组的结果放回原数组即可
        for(int i=0;i<len;i++){
            nums[i] = newNums[i];
        }
    }
}

//空间O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        // 数组长度
        int length = nums.length;
        // k 可能会大于数组长度，所以要对其取模
        k %= length;
        // 首先把整个数组翻转一下
        reverse(nums, 0, length-1);
        // 再把[0,k]之间的数字翻转一下
        reverse(nums, 0, k-1);
        // 最后把[k,length-1]之间的数字翻转一下
        reverse(nums, k, length-1);
    }
    
    // 翻转数组
    public void reverse(int[] nums, int begin, int end){
        // 双指针
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
