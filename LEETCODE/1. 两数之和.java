class MySolution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int result[] = new int[2];
        loop:
        for(int i=0;i<length;i++) {
            for(int j=0;j<length;j++) {
                if(nums[i]+nums[j]==target&&j!=i) {
                    result[0] = i;
                    result[1] = j;
                    break loop;
                }
            }
            
        }
        return result;
    }
}

class OthersSolution{
    public int[] twoSum(int[] nums,int target) {
        int result[] = new int[2];
        if(nums==null||nums.length<2)
            return result;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            if(!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            }else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int dvalue = target - nums[i];
            if (map.containsKey(dvalue)){
                return new int[]{map.get(dvalue), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No pairs of number");
    }
}
