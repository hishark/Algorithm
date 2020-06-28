class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int res = 0;
        for (int i=0;i<n;i++) {
            nums[i] = start + 2*i;
            res ^= nums[i];
        }
        return res;
    }
}
