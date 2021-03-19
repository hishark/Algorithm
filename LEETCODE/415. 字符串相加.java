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
            // 取出两个字符串当前的数字，转换为int类型用于相加
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            // 求和
            int tmp = n1 + n2 + carry;
            // 计算进位
            carry = tmp / 10;
            // 把当前位的结果加入到结果字符串中
            res.append(tmp % 10);
            // 继续计算上一位
            i--;
            j--;
        }
        // 结束循环后，检查一下是否存在进位，如果存在就加入到结果中
        if(carry == 1) 
            res.append(1);
        // 最后反转结果字符串即可
        return res.reverse().toString();
    }
}

// ref：https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/