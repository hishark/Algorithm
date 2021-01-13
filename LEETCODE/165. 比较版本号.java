// 分割字符串
class Solution {
    public int compareVersion(String version1, String version2) {
        // 分割版本号
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        // 两个版本号的长度
        int len1 = nums1.length, len2 = nums2.length;

        // 当前遍历的数字
        int str1, str2;
        // 遍历较长的数组
        for (int i = 0; i < Math.max(len1, len2); i++) {
            // 逐个比较
            // 如果其中一个数组结束了，需要尾部补0，以进行比较
            // version1 的某块
            str1 = i < len1 ? Integer.parseInt(nums1[i]) : 0;
            // version2 的某块
            str2 = i < len2 ? Integer.parseInt(nums2[i]) : 0;
            // 如果对应的两块数字不相同，那么直接返回即可
            if (str1 != str2) {
                return str1 > str2 ? 1 : -1;
            }
        }
        // 如果遍历完数组，每一块数字都相同，那么就返回 0
        return 0;
    }
}

// ref：https://leetcode-cn.com/problems/compare-version-numbers/solution/bi-jiao-ban-ben-hao-by-leetcode/

// 双指针
// 这个解法还没看，搁置一下
class Solution {
    /**
     * 用于检索字符串中的下一个块
     * @param version 输入字符串
     * @param n 字符串长度
     * @param p 要检索的块的第一个字符
     * @return
     */
    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        // if pointer is set to the end of string
        // return 0
        if (p > n - 1) {
            return new Pair(0, p);
        }
        // find the end of chunk
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }
        // retrieve the chunk
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        } else {
            i = Integer.parseInt(version.substring(p, n));
        }
        // find the beginning of next chunk
        p = pEnd + 1;

        return new Pair(i, p);
    }

    public int compareVersion(String version1, String version2) {
        // 双指针
        int p1 = 0, p2 = 0;
        // 两个版本号的长度
        int n1 = version1.length(), n2 = version2.length();

        // compare versions
        int i1, i2;
        Pair<Integer, Integer> pair;
        while (p1 < n1 || p2 < n2) {
            pair = getNextChunk(version1, n1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // 版本号相同
        return 0;
    }
}