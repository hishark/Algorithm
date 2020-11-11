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