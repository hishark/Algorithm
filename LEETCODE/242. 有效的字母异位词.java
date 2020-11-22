import java.util.Arrays;

// ref: https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/

// 1. 排序
class Solution {
    public boolean isAnagram(String s, String t) {
        /**
         * t 是 s 的字母异位词等价于「两个字符串排序后相等」
         * 所以可以对两个字符串分别排序，看排序后的字符串是否相等即可判断
         */

        // 如果两个字符串的长度不同，必然不互为字母异位词
        if (s.length() != t.length()) 
            return false;

        // 把字符串转换为字符数组
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        // 对字符串进行排序
        Arrays.sort(s1);
        Arrays.sort(t1);

        // 判断排序后的字符串是否相同即可
        return Arrays.equals(s1, t1);

    }
}

// 2. 哈希表
class Solution {
    public boolean isAnagram(String s, String t) {
        /**
         * t 是 s 的异位词等价于「两个字符串中字符出现的种类和次数均相等」
         * 由于字符串只包含 26 个小写字母，所以可以维护一个长度为 26 的数组
         */

         // 如果两个字符串的长度不同，必然不互为字母异位词
        if (s.length() != t.length()) 
            return false;

        // 使用一个数组记录字符出现的次数
        int[] count = new int[26];

        // 遍历字符串 s，计算字符串 s 中所有字符出现的次数
        for (int i=0;i<s.length();i++) {
            count[s.charAt(i) - 'a']++;
        }

        // 遍历字符串 t，减去 count 数组中对应的次数
        // 如果出现小于 0 的情况，说明 t 中包含一个不在 s 中的额外字符
        for (int i=0;i<t.length();i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0)
                return false;
        }
 
        // 遍历完字符串 t 没出现小于零的情况就直接返回 true 啦
        return true;
    }
}