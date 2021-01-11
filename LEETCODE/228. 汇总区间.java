class Solution {
    public List<String> summaryRanges(int[] nums) {
        // 结果列表
        List<String> res = new ArrayList<String>();
        // 遍历下标
        int i = 0;
        // 数组长度
        int n = nums.length;
        // 对数组进行一次遍历
        while (i < n) {
            // 记下左边界
            int left = i;
            // 往右走
            i++;
            // 如果还在数组范围内，且数字连续，就一直往右
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            //记下右边界
            int right = i - 1;
            // 组成结果字符串
            StringBuffer curRange = new StringBuffer(Integer.toString(nums[left]));
            // 如果结果里只有一个数字，就不需要箭头啦
            if (left < right) {
                curRange.append("->");
                curRange.append(Integer.toString(nums[right]));
            }
            // 加入到最终结果列表中即可
            res.add(curRange.toString());
        }
        // 返回结果
        return res;
    }
}