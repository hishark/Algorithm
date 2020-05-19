//baoli
class Solution {
    fun myPow(x: Double, n: Int): Double {
        if(n==0) 
            return 1.0
        var ans = 1.0
        var i = 1
        var N = if(n>0) n else -n
        while(i<=N){
            ans *= x
            i++
        }
        return if(n>0) ans else 1/ans
    }
}

//fenzhi
class Solution {
    fun myPow(x: Double, n: Int): Double {
        if(n==0||x==1.0) return 1.0
        val N = n.toLong()
        return if(N<0) 1/divide(x, -N) else divide(x, N)
    }
    fun divide(x: Double, n: Long): Double {
        if(n==1L) return x
        val half = divide(x, n/2)
        return if(n%2!=0L) half*half*x else half*half
    }
}