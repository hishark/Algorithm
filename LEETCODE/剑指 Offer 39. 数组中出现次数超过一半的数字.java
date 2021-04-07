
// 摩尔投票法
// ref: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
class Solution {
    public int majorityElement(int[] nums) {
        // 众数
        int mode = 0;
        // 票数和
        int votes = 0;

        // 遍历所有数字
        for (int num : nums) {
            // 当票数和为 0 时，就假设当前数字是众数 mode
            if (votes == 0)
                mode = num;

            // 如果当前数字是众数，票数+1，反之票数-1
            if (num == mode)
                votes += 1;
            else
                votes -= 1;

        }

        return mode;
    }
}
// 1 2 3 3 3 3 4
// num = 1 mode = 1, vote = -1
// num = 2 mode = 1 vote = -2
// num = 3 mode = 1 vote = -1
// num = 3 mode = 1 vote = 0 
// num = 3 mode = 3 vote = 1
// num = 3 mode = 3 vote = 2
// num = 4 mode = 3 vote = 1       

/**
 * 字节面试的时候问过我这个问题，然后问有几种方法
 * 想到一些：
 *  1. 给数组排序，然后取中点
 *      快排，可以在排序中途就提前找到这个数
 *  2. 哈希表，统计即可
 *  3. 摩尔投票法
 *      不同则抵消，占半数以上的数字必然留到最后。
 */

 // cnt: 1