class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        // 最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 字符串的长度
        int n = s.length();
        // 我们可以遍历该序列，并记录当前分组的长度。
        // 如果下一个字符与当前字符不同，或者已经枚举到字符串尾部，
        // 就说明当前字符为当前分组的尾部。每次找到当前分组的尾部时，
        // 如果该分组长度达到 3，我们就将其加入答案。

        // 计数器，计算当前分组中的字符个数
        int cnt = 1;
        // 遍历字符串
        for (int i = 0; i < n; i++) {
            // 如果已经遍历到字符串尾部，或者当前字符与下一个字符不同
            // 就说明当前字符是当前分组的尾部
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                // 每次找到当前分组的尾部时，就判断分组长度
                // 如果长度 >= 3，符合要求，加入最终结果中即可
                if (cnt >= 3) {
                    // i 是当前下标
                    // cnt 是当前分组的字符个数
                    // i - cnt + 1 就是分组的起点下标
                    // i 就是分组的终点下标
                    // [i - cnt + 1, i] 即分组
                    res.add(Arrays.asList(i - cnt + 1, i));
                }
                // 接着遍历下一个分组，计数器重新初始化为 1
                cnt = 1;
            } else {
                // 计数器++
                cnt++;
            }
        }
        return res;
    }
}

// ref：https://leetcode-cn.com/problems/positions-of-large-groups/solution/jiao-da-fen-zu-de-wei-zhi-by-leetcode-so-fi3n/