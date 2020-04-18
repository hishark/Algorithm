//⬇暴力
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int length = height.length;
        for (int i=0;i<length;i++) {
            for(int j=i+1;j<length;j++) {
                int area = Math.min(height[i], height[j]) * (j-i);
                ans = Math.max(area, ans);
            }
        }
        return ans;
    }
}

//⬇双指针
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0;
        int j = len - 1;
        int ans = 0;
        while ( i < j ){
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j-i));
            if(height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}