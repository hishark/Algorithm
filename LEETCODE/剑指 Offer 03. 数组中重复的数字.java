// 法1 排序
class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == nums[i+1])
                return nums[i];
        }
        return -1;
    }
}

// 法2 哈希表
class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                return num;
            }else{
                map.put(num, 1);
            }
        }
        return -1;
    }
}

// 法3 比较交换
class Solution {
    public int findRepeatNumber(int[] nums) {
        // 从头到尾扫描数字
        for(int i=0;i<nums.length;i++) {
            // 当前扫描的数字为cur
            int cur = nums[i];
            
            // 判断cur和i是否相等
            // 若相等，继续扫描下一个数
            // 若不相等，比较cur和第cur个数
            if (cur != i) {
                if (cur == nums[cur]) {
                    // cur和第cur个数相等，说明找到了重复数，返回即可
                    return cur;
                } else {
                    // 不相等，交换两个数
                    int tmp = nums[cur];
                    nums[cur] = nums[i];
                    nums[i] = tmp;
                    cur = nums[i];
                }
            }
        }
        
        return -1;
    }
}
