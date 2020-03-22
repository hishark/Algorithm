//关键是要先排好序
//https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/ji-shu-onxian-xing-tan-ce-fa-onpai-xu-onlogn-yi-ya/
//这方法也太好嘞
class Solution {
    public int minIncrementForUnique(int[] A) {
        //先排好序(*)
        Arrays.sort(A);
        //初始化
        int move = 0;
        //遍历数组
        for(int i=1;i<A.length;i++){
            //如果当前数字小于等于上一个数字，就+1
            if(A[i]<=A[i-1]){
                int pre = A[i];
                A[i] = A[i-1] + 1;
                move += A[i] - pre;
            }

        }
        return move;
    }
}