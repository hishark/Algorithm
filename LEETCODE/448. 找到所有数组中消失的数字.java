
// 哈希表
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // 使用哈希表记录数字是否出现
        HashMap<Integer, Boolean> hashmap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], true);
        }
        
        // 结果列表
        List<Integer> result = new LinkedList<Integer>();
        
        // 遍历数组找到没有出现的数字即可 
        for (int i = 1; i <= nums.length; i++) {
            if (!hashmap.containsKey(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}

// ref：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-de-shu-zi-2/

// 原地算法
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            // 把当前数字的值减去1作为新的索引
            int newIndex = Math.abs(nums[i]) - 1;
            // 判断新索引处的nums值是否大于0，如果大于0的话就变成负数
            // 此时，索引的数值（指下标的数值）即在数组中出现过的数字
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        // 结果列表
        List<Integer> result = new LinkedList<Integer>();
        // 遍历数组
        for (int i = 1; i <= nums.length; i++) {
            // 如果nums没有变成负数，说明此处索引值没有出现过
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        // 返回结果即可
        return result;
    }
}
