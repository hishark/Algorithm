/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // 求中点
            int mid = left + (right - left) / 2;
            // 判断是不是错误版本
            if (isBadVersion(mid)) {
                // 如果是错误版本，说明其他的错误版本都在左边
                right = mid;
            } else {
                // 如果不是错误版本，说明错误版本一定在之后才出现，也就是右边
                left = mid + 1;
            }
        }
        // 返回 right 也一样
        return left;
    }
}