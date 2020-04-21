//这个不太行
class Solution {
    public String reverseString(String s) {
        StringBuffer test = new StringBuffer(s);
        test.reverse();
        s = new String(test);
        return s;
    }
}

//双指针
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while(i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}