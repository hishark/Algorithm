class Solution {
    public int mySqrt(int x) {
        int l=1,r=x;
        int ans = 0;
        while(l<=r){
            int mid = l + (r - l)/2;//int mid=(l+r)/2的变形式，防止溢出
            int div = x / mid;//int square = mid * mid的变形式，防止溢出
            if(div==mid){
                return mid;
            }else if(mid<div){// square<x =>  mid*mid<x => mid<x/mid => mid<div
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
}
