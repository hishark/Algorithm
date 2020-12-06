class Solution {
    public String reverseLeftWords(String s, int n) {
        String ans = "";
        for (int i = n; i < s.length(); i++) {
            ans += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            ans += s.charAt(i);
        }

        // 还可以用求余简化两个循环
        // for(int i = n; i < n + s.length(); i++)
        //     ans += s.charAt(i % s.length());


        return ans;
    }
}