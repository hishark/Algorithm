class Solution {
    public String addStrings(String num1, String num2) {
        // 最终结果
        StringBuilder res = new StringBuilder("");
        // 双指针
        int i = num1.length() - 1, j = num2.length() - 1;
        // 相加的进位
        int carry = 0;
        // 数字遍历完就结束循环
        while(i >= 0 || j >= 0){
            // 取出两个字符串当前的数字
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }
}

// ref：https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/