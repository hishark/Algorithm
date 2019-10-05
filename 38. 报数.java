class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for(int i=2;i<=n;i++){
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for(int j=1;j<str.length();j++){
                char c = str.charAt(j);
                if(c==pre){
                    count++;
                }else{
                    builder.append(count).append(pre);
                    count=1;
                    pre=c;
                }
            }
            builder.append(count).append(pre);//这里不要忘记还要append一次
            str = builder.toString();
        }
        return str;
    }
}
