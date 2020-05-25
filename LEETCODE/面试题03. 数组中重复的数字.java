class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                return num;
            }else{
                map.put(num, 1);
            }
        }
        return -1;
    }
}