// ref: https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
// 集合 set + 遍历
class Solution {
    public boolean isStraight(int[] nums) {
        // 利用 Set 判断是否存在重复的牌
        Set<Integer> set = new HashSet<>();
        // 初始化：五张牌中的最大值和最小值
        int min = 14;
        int max = 0;

        // 遍历五张扑克牌
        for (int num: nums) {
            // 大小王可以看作是任意数字，所以只要没有重复的牌
            // 同时【最大牌 - 最小牌 < 5】那么就是一个顺子
            if (num == 0)
                continue;

            // 存储最大的牌
            max = Math.max(max, num);

            // 存储最小的牌
            min = Math.min(min, num);

            // 如果出现了重复的牌，必定不是顺子！
            if (set.contains(num))
                return false;
             
            // 每遍历一个牌都放入 set（set会自动去重）
            set.add(num);
        }
        // 遍历完所有的牌之后，判断最大值和最小值的差
        return max - min < 5;
    }
}


// 排序 + 遍历
class Solution {
    public boolean isStraight(int[] nums) {
        // 大小王的数量
        int kingNum = 0;
        // 对数组进行排序
        Arrays.sort(nums);
        
        for (int i=0;i<4;i++) {
            // 统计大小王的数量
            if (nums[i] == 0)
                kingNum++;
            // 判断是否有重复的牌，如果有的话直接返回 false
            else if (nums[i] == nums[i+1])
                return false;
        }

        // 排序后，nums[4]是最大的牌
        // 统计好大小王的数量 kingNum 之后，nums[kingNum] 就是大小王之后最小的一张牌
        // 只要【最大牌 - 最小牌 < 5】就说明是一个顺子
        return nums[4] - nums[kingNum] < 5;
    } 
}
