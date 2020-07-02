class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                // 不停地把元素放进堆中
                heap.offer(matrix[i][j]);
                // 如果堆中的元素个数超过k，就把堆顶最大的元素删去
                if(heap.size()>k){
                    heap.poll();
                }
            }
        }
        // 最后，堆里只剩下k个元素，堆顶就是第k小的元素
        return heap.poll();
    }
}
