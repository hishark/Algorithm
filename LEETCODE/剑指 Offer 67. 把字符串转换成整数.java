class Solution {
    public int strToInt(String str) {
        // 先将字符串转换为字符数组，删除首尾空格
        char[] c = str.trim().toCharArray();

        // 判空
        if (c.length == 0)
            return 0;
        
        // 最终结果
        int ans = 0;
        // 边界
        int boundary = Integer.MAX_VALUE / 10;

        // 字符开始的位置
        int i = 1;
        // 符号位
        int sign = 1;
        // 判断符号
        if(c[0] == '-') 
            sign = -1;
        else if(c[0] != '+') 
            i = 0; // 如果第一位不是正负号，那么数字开始的位置就是 0
        
        // 从第一个字符开始遍历到最后一个字符
        for(int j = i; j < c.length; j++) {
            // 如果发现不是数字就直接跳过
            if(c[j] < '0' || c[j] > '9') 
                break;
            // 如果此时的结果已经超过边界值，直接根据符号返回整数的最大值 or 最小值
            if(ans > boundary || ans == boundary && c[j] > '7') 
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            // 结果没有越界，继续累加数字
            ans = ans * 10 + (c[j] - '0');
        }
        // 返回带符号的结果
        return sign * ans;

    }
}