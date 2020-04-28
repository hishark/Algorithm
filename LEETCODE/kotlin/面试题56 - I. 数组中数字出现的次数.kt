class Solution {
    fun singleNumbers(nums: IntArray): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            var num = nums[i]
            if (map.contains(num)) {
                val cnt = map.get(num)!! + 1
                map.put(num, cnt)
            } else {
                map.put(num, 1)
            }
        }

        var res = IntArray(2)
        var i = 0
        for (key in map.keys) {
            if (map[key] == 1) {
                res[i] = key
                i++
            }
        }

        return res
    }
}