class Solution {
    public String removeDuplicateLetters(String s) {
        // 记录每个字符是否出现在栈中
        boolean[] inStack = new boolean[26];

        // 使用数组计算字符串中每个字符出现的次数
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        // 栈
        StringBuffer stack = new StringBuffer();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 当前遍历字符
            char ch = s.charAt(i);
            // 如果当前字符不在栈中 
            if (!inStack[ch - 'a']) {
                // 给定一个字符串 s，如何去掉其中的一个字符 ch，使得得到的字符串字典序最小呢？
                // 答案是：找出最小的满足 s[i]>s[i+1] 的下标 i，并去除字符 s[i]。该字符即为「关键字符」
                // 如果栈不为空，且栈顶的字符大于当前字符，说明栈顶字符就是「关键字符」
                while (stack.length() > 0 && stack.charAt(stack.length() - 1) > ch) {
                    // 如果后面还有关键字符，就可以放心让此时栈顶的关键字符出栈
                    if (num[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                        inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                        stack.deleteCharAt(stack.length() - 1);
                    } else {
                        // 如果后面没有关键字符了，就留下它
                        break;
                    }
                }
                // 处理好了关键字符后，就来处理当前字符
                // 把当前字符放入栈中
                stack.append(ch);
                inStack[ch - 'a'] = true;
            }
            // 如果当前字符已经在栈中了，就不要再放进去了，我们的目标就是去除重复字符
            num[ch - 'a'] -= 1;
        }
        // 此时栈中剩下的就是去除了重复字符的字符串
        return stack.toString();
    }
}
// ref：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/qu-chu-zhong-fu-zi-mu-by-leetcode-soluti-vuso/