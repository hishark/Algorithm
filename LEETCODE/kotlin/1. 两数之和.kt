class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int,Int>()
        for(i in nums.indices) {
            val diff = target - nums[i]
            if(map.containsKey(diff)) {
                //!!表示相信这个值非空，不加!!会报错
                return intArrayOf(map[diff]!!, i)
            }
            //kotlin不推荐使用put和get
            map[nums[i]] = i
        }
        return intArrayOf(-1, -1)
    }
}