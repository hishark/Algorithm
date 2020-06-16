class Solution {
    fun reverseLeftWords(s: String, n: Int): String {
        var len = s.length
        return s.substring(n, len) + s.substring(0,n)
    }
}

class Solution {
    fun reverseLeftWords(s: String, n: Int): String {
        var res = ""
        for(i in n..s.length-1) {
            res += s[i]
        }
        for(i in 0..n-1) {
            res += s[i]
        }
        return res
    }
}