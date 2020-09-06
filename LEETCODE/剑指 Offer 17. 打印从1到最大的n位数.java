class Solution {
    public int[] printNumbers(int n) {
        int max = 0;
        while (n != 0){
            max = max * 10 + 9;
            n--;
        }
        int[] res = new int[max];
        for (int i=0;i<max;i++) {
            res[i] = i+1;
        }
        return res;
    }
}
