// 1
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // 记录某个字母是否存在
        boolean[] exist = new boolean[26];
        for (char c : letters) {
            exist[c - 'a'] = true;
        }

        while (true) {
            // 记得++，要找的是target之后的字符
            target++;

            // 如果越界了就回到最初的起点
            if (target > 'z')
                target = 'a';

            if (exist[target - 'a'])
                return target;
        }
    }
}

// 2
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        } 
        // 如果越界了就取模
        return letters[left % letters.length];
    }
}