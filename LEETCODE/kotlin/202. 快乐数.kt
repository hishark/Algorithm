//hash
class Solution {
    fun isHappy(n: Int): Boolean {
        var hashset = HashSet<Int>()
        var orgN = n
        while (true) {
            var newN = 0
            while(orgN!=0) {
                newN += (orgN%10) * (orgN%10) // 这里千万别忘记括号OTZ
                orgN /= 10
            }
            orgN = newN
            if( orgN == 1) {
                return true
            } else if (!hashset.add(orgN)) { 
                //hashset.add返回值为Boolean，如果hashset中已存在orgN，说明进入了循环，直接返回false
                return false
            }
        }
    }
}
//快慢指针
class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = getNewN(n)
        var fast = getNewN(getNewN(n))

        while(fast!=1 && fast!=slow){
            slow = getNewN(slow)
            fast = getNewN(getNewN(fast))
            if(slow == fast)
                return false
        }
        return fast == 1
    }

    fun getNewN(n: Int): Int {
        var newN = 0
        var orgN = n
        while(orgN!=0) {
            newN += (orgN%10) * (orgN%10)
            orgN /= 10
        }
        return newN;
    }
}