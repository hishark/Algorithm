import java.util.HashMap;

// ref: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
// 哈希表
class Solution {
    public char firstUniqChar(String s) {
        // 哈希表
        // key: 字符
        // value: true代表字符数量为1，false代表字符数量大于1
        HashMap<Character, Boolean> hashmap = new HashMap<>();

        // 把字符串转换为字符数组
        char[] ch = s.toCharArray();

        // 遍历所有字符
        for (char c : ch) {
            // 如果哈希表中不包含当前字符的话，则当前字符目前只有一个，哈希值为 true 。
            // 如果哈希表中包含当前字符的话，则当前字符目前大于一个，哈希值为 false 。
            hashmap.put(c, !hashmap.containsKey(c));
        }

        // 再遍历一遍所有字符，找到了哈希值为 true （即字符只有一个） 的字符直接返回即可
        for (char c : ch) {
            if (hashmap.get(c))
                return c;
        }

        // 不存在的话就返回单空格
        return ' ';
    }
}

// 有序哈希表
class Solution {
    public char firstUniqChar(String s) {
        // 有序哈希表
        Map<Character, Boolean> map = new LinkedHashMap<>();

        // 将字符串转换为字符数组
        char[] ch = s.toCharArray();

        // 遍历所有字符
        for (char c : ch) {
            // 如果哈希表中不包含当前字符的话，则当前字符目前只有一个，哈希值为 true 。
            // 如果哈希表中包含当前字符的话，则当前字符目前大于一个，哈希值为 false 。
            map.put(c, !map.containsKey(c));
        }

        // 遍历有序哈希表，找到第一个哈希值为 true （即字符只有一个）的字符直接返回即可
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue())
                return entry.getKey();
        }

        // 不存在的话就返回单空格
        return ' ';
    }
}