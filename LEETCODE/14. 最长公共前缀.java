class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 空数组
        if (strs.length == 0)
            return "";
        // 初始化ans为第一个字符串
        String ans = strs[0];
        // 遍历剩下的字符串，两两比较，最后的ans就是结果
        for (int i=1;i<strs.length;i++) {
            int j;
            for (j=0;j<ans.length() && j<strs[i].length();j++) {
                // 检测到对应位置的字符不相等时，就退出循环，更新ans
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            // 此时，ans的第0到j-1位的数字就是当前的最长公共前缀
            ans = ans.substring(0, j);
            // 如果此时就为空了，也没有必要继续往下检测了
            if (ans == "") {
                return ans;
            }
        }
        return ans;
    }
}