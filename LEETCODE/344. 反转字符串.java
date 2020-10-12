//双指针
class Solution {
    public void reverseString(char[] s) {
        // 双指针，一个指向头
        int i = 0;
        // 一个指向尾
        int j = s.length - 1;
        // 两个指针碰面时才结束循环
        // 「<」或者「<=」都可以，没差
        while(i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}