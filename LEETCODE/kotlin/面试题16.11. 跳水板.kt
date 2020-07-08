class Solution {
    fun divingBoard(shorter: Int, longer: Int, k: Int): IntArray {
        // 啥都不选就0了
        if(k == 0)
            return intArrayOf()
        
        // 长短相同时，直接选k块即可
        if(shorter == longer)
            return intArrayOf(k * shorter)
        
        // 一种是全部选短的
        // 另外k种是取长补短
        // 所以总共是k+1种方案
        var res =  IntArray(k+1)
        
        for(i in 0..k) {
            res[i] = shorter * (k-i) + longer * i
        }
        
        return res
    }
}
