//哈希
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            int count;
            if(map.containsKey(num)){
                count = map.get(num) + 1;
                map.put(num, count);
            }else{
                count = 1;
                map.put(num, count);
            }
            if(count>nums.length/2){
                return num;
            }
        }
        return -1;
    }
}

//分治
class Solution {
    
    //计算[left,right]范围内num出现的次数
    public int count(int[] nums, int num, int low, int high){
        int cnt = 0;
        //区间是闭区间[low, high]
        for(int i=low;i<=high;i++){
            if(nums[i]==num)
                cnt++;
        }
        return cnt;
    }
    
    public int majorityElementRec(int[] nums, int low, int high){
        //base case - 如果子区间只有一个数了，那么众数一定是这个数，返回即可
        if(low==high){
            return nums[low];
        }
        
        //子区间不止一个数
        int mid = (high-low)/2 + low;//别写错写出high+low了 - -
        //得到左区间的众数和右区间的众数
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid+1, high);
        
        //如果左众数=右众数，随便返回谁
        if(left==right)
            return left;
        
        //如果左众数不等于右众数，那么判断一下哪个数的出现次数更多，返回即可（要判断在整个区间内的出现次数）
        int leftCnt = count(nums, left, low, high);
        int rightCnt = count(nums, right, low, high);
        return leftCnt>rightCnt ? left : right;
    }
    
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}

// 摩尔投票法
class Solution {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int mode = 0;
        int votes = 0;

        for (int num: nums) {
            if (votes == 0)
                mode = num;

            if (num == mode)
                votes += 1;
            else 
                votes -= 1;
        }

        return mode;
    }
}