class Solution {
    fun validPalindrome(s: String): Boolean {
        var i=0
        var j=s.length-1
        while(i<j){
            if(s[i]!=s[j]){
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1)
            }
            i++
            j--
        }
        return true
    }
    fun isPalindrome(s: String, ii: Int, jj: Int): Boolean {
        var i = ii
        var j = jj
        while(i<j){
            if(s[i]==s[j]){
                i++
                j--
            }else{
                return false
            }
        }
        return true
    }
}