class Solution {
    // 字符串题，遍历替换即可，感觉面试不会考这种OTZ
    public String replaceSpace(String s) {
        char[] nums = new char[s.length() * 3];
        int index = 0;

        for (int i=0;i<s.length();i++) {
            if(s.charAt(i) != ' ') {
                nums[index++] = s.charAt(i);
            } else {
                nums[index++] = '%';
                nums[index++] = '2';
                nums[index++] = '0';
            }
        }
        // 字符数组转字符串的一种方式
        String res = new String(nums, 0, index);
        return res;

    }
}
