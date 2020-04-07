//暴力执法
//时间复杂度O(n^2) 数组中的n个元素每个都要扫描n次
//空间复杂度O(1) 
class Solution {
    public int trap(int[] height) {
        int max_left = 0;
        int max_right = 0;
        int res = 0;
        int length = height.length;

        //遍历整个数组
        for(int i=1;i<length-1;i++){
            //遍历当前柱子的左边，找出左边的最大高度
            for(int j=i;j>=0;j--){
                max_left = Math.max(max_left, height[j]);
            }

            //遍历当前柱子的右边，找出右边的最大高度
            for(int k=i;k<length;k++){
                max_right = Math.max(max_right, height[k]);
            }

            int water = Math.min(max_left, max_right) - height[i];
            //别忘记每算一轮都要初始化两个最大值
            max_left = 0;
            max_right = 0;
        
            res += water;
        }
        return res;
    }
}
//单调栈：维护栈内的元素单调递增或者递减
//Sweetiee Solution:
//https://leetcode-cn.com/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
//单调栈和暴力法的区别是，单调栈是一行行的增加雨水量，而暴力法是一列一列的增加雨水量
//时间复杂度O(n) 每个柱体最多入出栈一次
//空间复杂度O(n) 栈
class Solution {
    public int trap(int[] height) {
        //单调栈 - 单调递减
        //一旦递增了就开始计算一次雨水量
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(int i=0;i<height.length;i++){
            
            //如果一直递减就一直入栈，直到出现递增再进入循环
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curIndex = stack.pop();
                //如果栈顶元素重复，就全部出栈，记下curIndex即可
                while(!stack.isEmpty() && height[stack.peek()] == height[curIndex]){
                    stack.pop();
                }

                //如果此时栈仍未空，就开始计算雨水量
                if(!stack.isEmpty()){
                    int stackTop = stack.peek();
                    //雨水的高度 i是右边柱子右边界 stackTop是左边柱子左边界
                    int water_height = Math.min(height[stackTop], height[i]) - height[curIndex];
                    //雨水的宽度
                    int water_width = i - stackTop - 1; 
                    res += water_height * water_width;
                }
            }
            //一直单调递减就一直入栈
            stack.push(i);
        }
        return res;

    }
}