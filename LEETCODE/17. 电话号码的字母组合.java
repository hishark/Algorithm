class Solution {
    public List<String> letterCombinations(String digits) {
        // 所有可能的字母组合
        List<String> combinations = new ArrayList<String>();
        // 判空
        if (digits.length() == 0) {
            return combinations;
        }
        // 使用哈希表存储每个数字对应的所有可能字母
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        // 进行回溯操作
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        // 返回所有组合即可
        return combinations;
    }

    /**
     * 回溯
     * @param combinations 所有可能的字母组合
     * @param phoneMap 哈希表
     * @param digits 需要判断的字符串
     * @param index 从字符串的下标为 index 的字符开始回溯
     * @param combination 已有的字母排列
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 如果遍历到了最后，也就找到了一个完整的字母排列，加入结果里即可
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 字符串 dights 中下标为 index 的字符
            char digit = digits.charAt(index);
            // 从哈希表里找出，该字符对应的字母有哪些
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 遍历这些对应的字母
            for (int i = 0; i < lettersCount; i++) {
                // 添加到当前已有的字母排列中
                combination.append(letters.charAt(i));
                // 继续往下一个字符遍历
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 回溯，在已有的字母排列中删去当前字符
                combination.deleteCharAt(index);
            }
        }
    }
}

// ref：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/