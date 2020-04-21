//Easy
class Solution {
    public boolean isPowerOfFour(int num) {
        // 1是4的0次幂
        if(num<=0) {
            return false;
        }

        while(num%4==0){
            num/=4;
        }

        return num==1;
    }
}

//位运算待做