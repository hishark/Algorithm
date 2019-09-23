🔗https://leetcode-cn.com/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int num1 = x;
        int num2 = 0;
        while(x != 0){
            if(x%10==0)
                num2 = num2*10;
            else
                num2 = num2*10 + x%10; 
            x /= 10;
        }
        if(num1==num2)
            return true;
        else
            return false;
    }
}
