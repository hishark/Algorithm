class Solution {
    public int[] printNumbers(int n) {
        int max = 0;
        while (n != 0) {
            max = max * 10 + 9;
            n--;
        }
        int[] ans = new int[max];
        for (int i=1;i<=max;i++) {
            ans[i-1] = i;
        }
        return ans;
    }
}
