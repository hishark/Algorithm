import java.util.LinkedList;

class Solution {

    // 全排列问题
    // 结果列表
    List<String> ans = new LinkedList<>();

    // 所有字符
    char[] c;

    public String[] permutation(String s) {
        // 把字符串转换为字符
        c = s.toCharArray();

        dfs(0);
    }

    public void dfs(int x) {
        
    }
}