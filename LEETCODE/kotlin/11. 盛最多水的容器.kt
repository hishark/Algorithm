import kotlin.math.min
import kotlin.math.max
class Solution {
    fun maxArea(height: IntArray): Int {
        var ans = 0
        val length = height.size
        for (i in height.indices) {
            for (j in i+1 until length) {
                var area = min(height[i], height[j]) * (j-i)
                ans = max(area, ans)
            }
        }
        return ans;
    }
}

class Solution {
    fun maxArea(height: IntArray): Int {
        val size = height.size
        var i = 0
        var j = size - 1
        var ans = 0
        while( i < j ){
            ans = max(ans, min(height[i], height[j])* (j-i)) 
            if (height[i] <= height[j]) i++ else j--
        }
        return ans
    }
}