class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        //用一个map存chars里面的字符数
        char[] temp = chars.toCharArray();
        Map<Character, Integer> map;
        for(String word: words){
            //每遍历一个字符串记得重新初始化map
            map = new HashMap<Character, Integer>();
            //计算字符出现次数
            for(char ch:temp){
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }else{
                    map.put(ch, 1);
                }
            }

            //对word进行遍历
            char[] w = word.toCharArray();
            boolean flag = true;
            for(char ch:w){
                //map中不包含当前字符，false
                if(!map.containsKey(ch)){
                    flag = false;
                }else {
                    if(map.get(ch)==0){
                        flag = false;
                    }else{
                        //map中包含当前字符且个数>0
                        map.put(ch, map.get(ch)-1);
                    }
                }
            }
            if(flag){
                ans += word.length();
            }
        }
        return ans;
    }
}