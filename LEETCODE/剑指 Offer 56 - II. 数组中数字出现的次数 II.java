class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                int cnt = map.get(num);
                map.put(num, cnt+1);
            } else {
                map.put(num, 1);
            }
        }

        for (int key: map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}