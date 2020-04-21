//Easy
//二分查找
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        //不能用int 不然while循环中相乘会超出范围
        long left = 2;
        long right = num/2;
        long center;
        //别忘了=
        while(left<=right){
            //求中点用这个
            center = left + (right - left) / 2;
            //center = (left+right)/2;
            if(center*center==num){
                return true;
            } else if (center*center < num) {
                left = center + 1;
            } else {
                right = center - 1;
            }
            
        }
        return false;
    }
}