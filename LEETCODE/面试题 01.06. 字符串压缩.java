class Solution {
    public String compressString(String S) {
        if(S.length()==0){
            return "";
        }
        //压缩串
        String ans = "";
        //原字符串的字符数组
        char[] ch = S.toCharArray();
        //当前扫描的字符，以及出现次数
        char current=ch[0], count=1;
        //遍历字符串
        for(int i=1;i<ch.length;i++){
            if(ch[i]==current){
                count++;
            }else{
                ans += (current + Integer.toString(count));
                current = ch[i];
                count = 1;
            }
        }
        ans += (current + Integer.toString(count));
        return S.length()<=ans.length()?S:ans;
    }
}