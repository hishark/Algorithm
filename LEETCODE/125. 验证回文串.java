class Solution {
    public boolean isPalindrome(String s) {
        s = s.replace(" ", "").toLowerCase();

        if(s==""){
            return true;
        }
        
        String result = "";
        for(char c: s.toCharArray()){
            if((c>='a'&&c<='z') || (c>='A'&&c<='Z') || (c>='0'&&c<='9')){
                result = result + c + "";
            }
        }
        char[] ch = result.toCharArray();
        for(int i=0,j=ch.length-1;i<j;i++,j--){
            if(ch[i]!=ch[j]){
                return false;
            }
        }
        return true;
    }
}

