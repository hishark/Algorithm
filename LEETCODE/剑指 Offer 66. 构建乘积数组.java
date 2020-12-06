class Solution {
    public int[] constructArr(int[] a) {
        // 判空
        if (a.length == 0)
            return new int[0];

        // 创建 b 数组
        int[] b = new int[a.length];
        // 赋初值
        b[0] = 1;
        // 工具人 tmp
        int tmp = 1;
        /**
         * 去看K佬画的表格 第一个循环是在计算「下三角」部分的值
         */
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        // 第二个循环是在计算「上三角」部分的值
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        
        return b;
    }
}

// dp:
class Solution {
    public int[] constructArr(int[] a) {
        // 判空
        if (a == null || a.length == 0) 
            return a;
        // 数组长度
        int len = a.length;
        // 以a[i]为分界线，可以分出一左一右两个数组
        int[] left = new int[len];
        int[] right = new int[len];
        // left从左边开始，right从右边开始
        left[0] = right[len - 1] = 1;

        // left[i]表示a[0]..a[i-1]的累积乘积
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        // right[i]表示
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}


// dp:
class Solution {
    public int[] constructArr(int[] a) {
        // 数组长度
        int n = a.length;
        // 结果数组
        int[] res = new int[n];
        // 初始化
        int k = 1;
        // 以a[i]为分界线，可以分出一左一右两个数组
        // 左边的数组：
        for(int i = 0; i < n; i++){
            res[i] = k; // res数组此时存储的是除去当前元素左边的元素乘积
            k *= a[i]; // k累乘
        }
        // 右边的数组：
        k = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积，res数组此时等于该数左边的 * 该数右边的
            k *= a[i]; // k累乘
        }
        // 返回结果即可
        return res;
    }
}