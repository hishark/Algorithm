class Solution {
    fun findRepeatNumber(nums: IntArray): Int {
        var map: MutableMap<Int, Int> = mutableMapOf()
        for(num in nums) {
            if(map.contains(num)){
                return num
            }else{
                map.put(num, 1)
            }
        }
        return -1
    }
}