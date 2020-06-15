class Solution {
    fun dailyTemperatures(T: IntArray): IntArray {
        // 暴力
        val length = T.size
        // 结果数组
        var res = IntArray(length)
        // 遍历每日气温
        for (i in 0..length-1) {
            var flag = true
            for (j in i+1..length-1) {
                // 之后的气温一旦高于今日气温，就把【位置差j-i】存入结果数组
                if (T[j] > T[i]) {
                    flag = false
                    res[i] = j - i
                    // 记 得 b r e a k ！
                    break
                }
            }
            // 如果之后的气温都小于等于今日气温，那么就置为0
            if (flag) {
                res[i] = 0
            }
        }
        return res
    }
}