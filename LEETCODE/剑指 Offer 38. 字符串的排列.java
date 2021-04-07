// ref: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
class Solution {
    // 全排列问题
    // 结果列表
    List<String> ans = new LinkedList<>();

    // 所有字符
    char[] chars;

    public String[] permutation(String s) {
        // 把字符串转换为字符
        chars = s.toCharArray();

        // 首先固定第 0 个字符
        dfs(0);

        // 返回结果即可
        // List.toArray(): https://blog.csdn.net/judyfun/article/details/50239127
        return ans.toArray(new String[ans.size()]);
    }

    // 深度优先搜索所有排列方案
    public void dfs(int n) {
        // 递归终止条件： 如果递归到了最后一个字符，就把目前的排列方案加入到结果列表里
        if (n == chars.length - 1) {
            ans.add(String.valueOf(chars));
            return;
        }

        // 初始化一个 set 用于排除重复的字符
        HashSet<Character> set = new HashSet<>();

        // 注意这里是 i=n 不是 i=0，从 n 开始搜索的！
        for (int i = n; i < chars.length; i++) {
            // set 中如果存在当前字符，说明重复，因而剪枝，继续查看下一个字符
            if (set.contains(chars[i]))
                continue;

            // 把当前字符加入到 set 中
            set.add(chars[i]);

            // 交换 chars[i] 和 chars[x]，将 chars[i] 固定在第 n 位
            swap(i, n);

            // 固定第 n+1 位字符
            dfs(n + 1);

            // 恢复交换，继续查看下一个字符
            swap(i, n);
        }

    }

    // 交换 chars 中位置 x 和 y 上的字符
    public void swap(int x, int y) {
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }

}