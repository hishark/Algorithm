class Solution {
    fun exchange(nums: IntArray): IntArray {
        // 使用双指针i和j，i从左向右移动，j从右向左移动
        var i = 0
        var j = nums.size - 1
        // 工具人tmp
        var tmp: Int

        // i和j没有相遇就一直循环下去
        while (i < j) {
            /**
             * 除了使用 n%2 是否等于 0 来判断n的奇偶，还可以使用 n&1 是否等于 0 来判断 n 的奇偶
             * 如果 n&1 == 0 说明 n 是偶数，如果 n&1 == 1 说明 n 是奇数。
             *
             * i 从左往右寻找偶数，j 从右往左寻找奇数，找到了就将二者指向的数字交换一下
             */

            // 如果 i 指向的数字是奇数就不停的往右移动
            while (i < j && nums[i] and 1 == 1)
                i++

            // 如果 j 指向的数字是偶数就不停的往左移动
            while (i < j && nums[j] and 1 == 0)
                j--

            // 当 i 指向了偶数，j 指向了奇数，就交换二者指向的数字，派出工具人 tmp
            tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }

        return nums
    }
}