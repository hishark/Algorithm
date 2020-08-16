class Solution {
    public int minOperations(int n) {
        int mid;
        if (n % 2 != 0) {
            int midIndex = n / 2;
            mid = 2*midIndex + 1;
        } else {
            int index1 = n / 2;
            int index2 = n / 2 - 1;
            mid = ((2*index1 + 1) + (2*index2 + 1)) / 2;
        }
        int res = 0;
        for (int num=1;num<=mid;num+=2) {
            int cut = mid - num;
            res += cut;
        }
        return res;
    }
}
