class Solution {
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        int[] res = new int[2];
        int i = 0;
        for(int key: map.keySet()) {
            if(map.get(key) == 1) {
                res[i] = key;
                i++;
            }
        }

        return res;
    }
}