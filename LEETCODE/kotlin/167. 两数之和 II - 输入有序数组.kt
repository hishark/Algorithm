class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                break
            }
        }

        return intArrayOf(left + 1, right + 1)
    }
}
