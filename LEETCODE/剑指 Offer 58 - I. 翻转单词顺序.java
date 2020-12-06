// ref: https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
class Solution {
    public String reverseWords(String s) {
        // 首先，先去除字符串头尾的空格
        s = s.trim();

        // 倒序遍历字符串，记录当前遍历单词的左右边界 left 和 right
        int left = s.length() - 1;
        int right = s.length() - 1;

        // 结果字符串
        StringBuilder ans = new StringBuilder();

        // 从头到尾，倒序遍历字符串
        while (left >= 0) {
            // 搜索第一个空格
            while(left >= 0 && s.charAt(left) != ' ')
                left--;

            // 找到空格之后，把单词加入到结果字符串中
            String word = s.substring(left + 1, right + 1) + " ";
            ans.append(word);

            // 跳过单词之间的空格（可能有多个）
            while(left >= 0 && s.charAt(left) == ' ')
                left--;
            
            // right 继续指向下一个单词的尾部
            right = left;
        }
        // 添加单词时会引入多余的空格，记得去除
        return ans.toString().trim();
    }
}