class Solution {
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

        String res = new String(nums, 0, index);
        return res;

    }
}
