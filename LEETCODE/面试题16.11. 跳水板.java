class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        // 啥都不选就0了
        if(k==0)
            return new int[]{};
        
        // 长短相同时，直接选k块即可
        if(shorter==longer)
            return new int[]{k*shorter};
        
        // 一种是全部选短的
        // 另外k种是取长补短
        // 所以总共是k+1种方案
        int[] res = new int[k+1];
        
        for(int i=0;i<res.length;i++) {
            res[i] = shorter * (k-i) + longer * i;
        }
        
        return res;
    }
}
