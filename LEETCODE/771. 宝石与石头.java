class Solution {
    public int numJewelsInStones(String J, String S) {
        // 哈希表
        Map<Character, Boolean> map = new HashMap<>();

        // 遍历字符串J，把宝石的类型记下来
        for(int i=0;i<J.length();i++) {
            char c = J.charAt(i);
            map.put(c, true);
        }

        // 宝石的数量
        int cnt = 0;

        // 遍历字符串S，统计宝石的数量
        for(int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if (map.containsKey(c))
                cnt++;
        }

        // 返回即可
        return cnt;
    }
}