//智障哈希表
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int key: nums){
            //哈希表里没有当前数字
            if(!map.containsKey(key)){
                map.put(key, 1);
            }else{
                //哈希表里已存在当前数字，count++
                int count = map.get(key) + 1;
                map.put(key, count);
            }
            
        }
        for(int i: map.keySet()){
            int count = map.get(i);
            if(count==1)
                return i;
        }
        return -1;
    }
}

//牛批位运算
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums){
            result ^= num;
        }
        return result;
    }
}
位运算也忒帅了
