class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int cnt = map.get(num);
                map.put(num, cnt + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}

// ref:
// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
// 位运算
class Solution {
    public int singleNumber(int[] nums) {
        // 建立一个长度为 32 的数组
        // 记录所有数字的各个二进制位中 1 出现的次数
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                // 使用与运算，可以获取 nums[i] 的二进制最低位 n0
                counts[j] += nums[i] & 1;
                // 无符号右移 nums[i]，在之后的循环中不断的获取 nums[i] 的二进制每一位 n1,n2,...,n31
                nums[i] >>>= 1;
            }
        }
        // 将 counts 各元素对 3 求余，结果就是「只出现一次的数字」的各二进制位
        for (int i = 0; i < 32; i++)
            counts[i] %= 3;

        // 只出现一次的数字
        int onlyOne = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            // 把结果左移一位，空出最低位
            onlyOne <<= 1;
            // 把第 i 位的二进制值恢复到 onlyOne 上
            onlyOne |= counts[i];
        }
        return onlyOne;
    }
}