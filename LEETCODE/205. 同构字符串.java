//Easy
class Solution {
    public boolean isIsomorphic(String s, String t) {
        //有空串直接返回false
        if(s==null || t==null){
            return false;
        }
        // 不仅仅是s可以映射到t，t也要能映射到s
        return inverse(s, t) & inverse(t, s);
    }

    public boolean inverse(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            //map的key为s当前的字符，value为t当前的字符，建立一一对应的关系
            //如果map里没有key为s[i]的元素，就加入进去
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                //如果map里存在key为s[i]的元素，检查其value是否等于t[i]
                //若不等，返回false
                if(map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        //最后返回true
        return true;
    }
}