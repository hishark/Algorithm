class Solution {
    fun singleNumber(nums: IntArray): Int {
        var map: MutableMap<Int, Int> = mutableMapOf()
        for(num in nums){
            if(map.contains(num)){
                var cnt: Int = (map[num]?:0) + 1
                map[num] = cnt
            }else{
                map[num] = 1
            }
        }
        for((key, value) in map){
            if(value==1){
                return key
            }
        }
        return 1
    }
}