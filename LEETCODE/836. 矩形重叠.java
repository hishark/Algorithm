class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //<rec[0]左 <rec[1]下 >rec[2]右 >rec[3]上
        //注意别漏了等于
        return !(rec2[2]<=rec1[0]||rec2[0]>=rec1[2]||rec2[3]<=rec1[1]||rec2[1]>=rec1[3]);
    }
}