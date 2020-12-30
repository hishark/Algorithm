public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 可以种花的数目
        int count = 0;
        // 从左到右扫描数组
        for (int i=0;i<flowerbed.length;i++) {
            // 如果数组中有一个 0，并且这个 0 的左右两侧都是 0，那么就可以在这个位置种花
            // 对于头尾只需要考虑一侧是否是 0 即可
            // 官方题解这个判断条件写的太优秀了OTZ
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        // 最后比较一下大小即可，只要 count 大于等于 n 都说明可以种下 n 朵花
        return count >= n;
    }
}
// ref：https://leetcode-cn.com/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode/