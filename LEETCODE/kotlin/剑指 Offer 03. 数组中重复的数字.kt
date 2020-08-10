//法1 排序
class Solution {
    fun findRepeatNumber(nums: IntArray): Int {
        Arrays.sort(nums)
        for (i in nums.indices) {
            if (nums[i] == nums[i + 1])
                return nums[i]
        }
        return -1
    }
}

// 法2 哈希表
class Solution {
    fun findRepeatNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            if (map.containsKey(num)) {
                return num
            } else {
                map[num] = 1
            }
        }
        return -1
    }
}

// 法3 比较交换
class Solution {
    fun findRepeatNumber(nums: IntArray): Int {
        // 从头到尾扫描数字
        for (i in nums.indices) {
            // 当前扫描的数字为cur
            var cur = nums[i]

            // 判断cur和i是否相等
            // 若相等，继续扫描下一个数
            // 若不相等，比较cur和第cur个数
            while (cur != i) {
                if (cur == nums[cur]) {
                    // cur和第cur个数相等，说明找到了重复数，返回即可
                    return cur
                } else {
                    // 不相等，交换两个数
                    val tmp = nums[cur]
                    nums[cur] = nums[i]
                    nums[i] = tmp
                    cur = nums[i]
                }
            }
        }

        return -1
    }
}
