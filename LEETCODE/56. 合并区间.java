class Solution {
    public int[][] merge(int[][] intervals) {
        //结果列表
        List<int[]> result_list = new ArrayList<>();

        //按照区间从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //遍历数组
        for(int[] cur: intervals) {
            int cur_start = cur[0];
            int cur_end = cur[1];
            int last_end = -1;
            
            // 结果列表为空时，或者当前数组的起点大于结果列表中最后一个数组的终点，直接把当前数组加入到结果列表
            if(result_list.size()==0 || cur_start > result_list.get(result_list.size()-1)[1]) {
                result_list.add(cur);
            } else {
                // 如果结果列表不为空，且当前数组的起点在结果列表最后一个数组的终点之前，那么就要合并数组
                // 合并后数组的终点，由这两个数组终点的最大值来决定
                result_list.get(result_list.size()-1)[1] = Math.max(result_list.get(result_list.size()-1)[1], cur_end);
            }
        }

        int[][] res = new int[result_list.size()][2];

        // list -> array
        int i = 0;
        for(int[] a: result_list) {
            res[i][0] = result_list.get(i)[0];
            res[i][1] = result_list.get(i)[1];
            i++;
        }
    
        return res;
    }
}