class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        String ans = "";
        for(int i=str.length-1;i>=0;i--){
            if(str[i].length()==0){
                continue;
            }
            ans += str[i];
            if(i>0){
                ans += " ";
            }
        }
        return ans;
    }
}