//Easy
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++) {
            if(map.containsKey(ch[i])) {
                int cnt = map.get(ch[i]) + 1;
                map.put(ch[i], cnt);
            } else {
                map.put(ch[i], 1);
            }
        }

        for(int i=0;i<ch.length;i++) {
            if(map.get(ch[i])==1){
                return i;
            }
        }
        return -1;
    }
}