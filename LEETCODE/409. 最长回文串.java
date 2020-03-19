//直接new一个int数组就好啦！
class Solution {
    public int longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        //拿一个map记下所有字符出现的次数
        int[] count = new int[128];
        for(char c:ch){
            count[c]++;
        }
        int ans = 0;
        for(int cnt:count){
            //如果cnt是奇数，这个操作就相当于cnt-1
            ans += cnt / 2 * 2;
            //只对一个奇数进行+1操作
            if(cnt%2==1 && ans%2==0){
                ans++;
            }
        }
        return ans;
    }
}

//HashMap 可行 但是太繁琐太慢
class Solution {
    public int longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        //拿一个map记下所有字符出现的次数
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c:ch){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        //如果map里只有一个字符，直接返回字符串长度即可
        if(map.size()==1){
            return s.length();
        }
        //初始化
        int ans = 0;
        boolean flag = false;
        int maxCount = 0;
        //遍历HashMap
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int count = entry.getValue();
            if(count%2==0){
                //出现偶数次数的字符直接加上数量
                ans+=count;
            }else{ 
                //出现奇数次数的字符加上(数量-1)
                flag = true;
                ans+=(count-1);
            }
        }
        //最后判断一下如果存在奇数次数的字符，就再加1即可（摆中间啦）
        if(flag){
            return ans+1;
        }else{
            return ans;
        }
        
    }
}