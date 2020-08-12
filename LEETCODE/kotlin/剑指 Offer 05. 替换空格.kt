class Solution {
    fun replaceSpace(s: String): String {
        val nums = CharArray(s.length * 3)
        var index = 0

        for (i in 0..s.length-1) {
            if (s[i] != ' ') {
                nums[index++] = s[i]
            } else {
                nums[index++] = '%'
                nums[index++] = '2'
                nums[index++] = '0'
            }
        }

        return String(nums, 0, index)
    }
}
