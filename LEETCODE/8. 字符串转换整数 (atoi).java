//注意点
//1. 不要一次性去除所有的空格 比如“ +0 123”应该输出0而不是123
//2. 判断是否越界时，不要写成ans*10+num>MAX，左边执行时已经越界了就不是原来的数了，写到右边去即可
//reference: 
//https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
//For Integer:
//max = 2^31-1
//min = 2^31
//max+1 = min
//min-1 = max
class Solution {
    public int myAtoi(String str) {
        //先去除前置的所有空格
        int index = 0;
        int length = str.length();
        char[] ch = str.toCharArray();
        while(index<length && ch[index]==' '){
            index++;
        }

        //去除空格后如果到了末尾，直接返回0
        if(index==length){
            return 0;
        }

        //判断是否为负数
        boolean isNeg = false;
        if(ch[index]=='-'){
            isNeg = true;
            index++;
        }else if(ch[index]=='+'){
            index++;
        }

        // 最终结果
        int res = 0;

        //当字符为数字时进行累加
        while(index<length && isNum(ch[index])){
            int num = ch[index] - '0';
            // 为了防止越界，将 res * 10 + num > Integer.MAX_VALUE 不等式移动了一下
            // 如果已经比最大值还要大了，就看是负数还是正数
            // 负数返回Integer.MIN_VALUE，正数返回Integer.MAX_VALUE
            if(res > (Integer.MAX_VALUE - num) / 10){
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // 累加
            res = res*10+num;
            // 索引右移
            index++;
        }
        // 返回结果
        return isNeg ? -res : res;
    }

    public boolean isNum(char c){
        if(c>='0'&&c<='9'){
            return true;
        }else{
            return false;
        }
    }
}