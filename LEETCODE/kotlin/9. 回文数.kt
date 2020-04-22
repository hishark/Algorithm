class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x<0) return false
        var x1 = x
        var x2 = 0
        while (x1!=0) {
            x2 = if(x1%10==0) x2*10 else x2*10+x1%10
            x1 /= 10
        }
        return if(x2==x) true else false;
    }
}