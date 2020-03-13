class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //如果存在ans，那么str1 + str2 = str2 + str1
        //不存在的话就 str1 + str2 != str2 + str1
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }

        //存在，找出ans
        int gcd = getGCD(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    //求最大公约数
    public int getGCD(int a, int b){
        return b==0 ? a : getGCD(b , a%b);
    }
}