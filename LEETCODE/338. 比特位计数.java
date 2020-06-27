class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;

        for (int i=1;i<=num;i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    public int count(int n) {
        int cnt = 0;
        while (n!=0) {
            if (n%2==1) {
                cnt++;
            }
            n/=2;
        }
        return cnt;
    }
}


class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;

        for (int i=1;i<=num;i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    public int count(int n) {
        int cnt = 0;
        while (n!=0) {
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }
}
