class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 暴力
        int length = T.length;
        // 结果数组
        int[] res = new int[length];
        // 遍历每日气温
        for (int i=0;i<length;i++) {
            boolean flag = true;
            for (int j=i+1;j<length;j++) {
                // 之后的气温一旦高于今日气温，就把【位置差j-i】存入结果数组
                if (T[j] > T[i]) {
                    flag = false;
                    res[i] = j - i;
                    // 记 得 b r e a k ！
                    break;
                }
            }
            // 如果之后的气温都小于等于今日气温，那么就置为0
            if (flag) {
                res[i] = 0;
            }
        }
        return res;
    }
}