class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 保证第一个数组比第二个数组短
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // 遍历nums1，计算nums1数组中的元素个数 
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            if(map.containsKey(num)) {
                int cnt = map.get(num);
                map.put(num, cnt + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 结果数组
        int[] res = new int[nums1.length];
        int index = 0;

        // 遍历nums2，计算交集
        for (int num: nums2) {
            int count = map.getOrDefault(num, 0);
            // count非0，说明map中存在num
            if (count > 0) {
                // 添加到结果数组中
                res[index++] = num;
                // num的次数--
                count--;
                // 若count不为0就更新
                if (count > 0) {
                    map.put(num, count);
                } else {
                    // count为0直接移除该数字
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }
}
