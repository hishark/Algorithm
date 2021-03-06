class Solution {
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        // 字典树根结点
        Trie root = new Trie();
        // 构建字典树
        for (String word: dictionary) {
            root.insert(word);
        }

        // 状态数组
        // dp[i]表示前i个字符（也就是s[0,i-1]）的最少未识别字符数
        // 题目所求即为dp[n]（也就是s[0,n-1]）的最少未识别字符数
        int[] dp = new int[n+1];

        // 边界条件
        dp[0] = 0;

        // 状态转移
        for (int i=1;i<=n;i++) {
            // 首先让dp[i]复用dp[i-1]的状态再加上未被识别的第i个字符
            // 此时是先假设第i个字符无法被识别
            dp[i] = dp[i-1] + 1;

            // 每一次查找，都从根节点开始
            Trie curPos = root;

            // j最小为1
            for (int j=i;j>=1;j--) {
                int index = sentence.charAt(j-1) - 'a';
                // 当前结点没有子结点，直接结束
                if (curPos.next[index] == null) {
                    break;
                } else if (curPos.next[index].isEnd) {
                    // 成功走到了单词末尾，说明该单词(s[j-1,i-1])存在，更新dp值
                    // 注意字符串下标从0开始，下标别搞错了
                    dp[i] = Math.min(dp[i], dp[j-1]);
                }

                // 如果dp[i]为0，已经无法更小，可以直接结束循环，减少判断次数，提高效率
                // 不判断也没关系，试了一下，不判断的话用时就多了几毫秒而已
                if(dp[i] == 0) {
                    break;
                }

                // 字典树往子结点走
                curPos = curPos.next[index];
            }
        }

        return dp[n];
    }
}

class Trie {
    Trie[] next;
    boolean isEnd;

    Trie() {
        next = new Trie[26]; //26个小写字母
        isEnd = false;
    }

    // 把一个字符串倒序插入到字典树中
    public void insert(String s) {
        Trie curPos = this;

        for (int i=s.length()-1;i>=0;i--) {
            // 字母对应的下标
            int index = s.charAt(i) - 'a';

            // 如果当前结点的子结点中不存在当前字母，就添加一个子结点
            if (curPos.next[index] == null) {
                curPos.next[index] = new Trie();
            }

            // 往下一个子结点移动
            curPos = curPos.next[index];
        }

        // 整个字符串遍历完，记得给最后一个字符打上结束标签
        curPos.isEnd = true;
    }
}
