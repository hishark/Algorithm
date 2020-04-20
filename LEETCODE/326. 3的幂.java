//Easy
class Solution {
    public boolean isPowerOfThree(int n) {
        //负数直接返回false，别漏了0不然会超时
        if(n<=0){
            return false;
        }
        //如果n可以整除3就一直除下去
        while(n%3==0){
            n/=3;
        }
        //如果是3的幂次方一定会得到1，如果不是1说明不是3的幂次方
        return n==1;
    }
}