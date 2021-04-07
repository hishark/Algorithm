class Solution {
    public int[] printNumbers(int n) {
        int max = 0;
        while (n != 0){
            max = max * 10 + 9;
            n--;
        }
        int[] res = new int[max];
        for (int i=0;i<max;i++) {
            res[i] = i+1;
        }
        return res;
    }
}


class Solution {
    public int[] printNumbers(int n) {
        // [1, 10^n - 1]
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }
}


// 大数越界解法： 当 n 较大时，end 会超出 int32 整型的取值范围，超出取值范围的数字无法正常存储。
// 不想看 OTZ
class Solution {
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}

// ref：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/