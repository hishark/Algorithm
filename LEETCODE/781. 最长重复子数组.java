// 暴力法 - 计算最长公共前缀
// 这个方法会超时！
class Solution {
    public int findLength(int[] A, int[] B) {
        // 结果，最长重复子数组的长度
        int ans = 0;
        // 每次比较时最长公共前缀的长度
        int len = 0;
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<B.length;j++) {
                len = 0;
                while(i+len<A.length && j+len<B.length && A[i+len] == B[j+len])
                    len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}


