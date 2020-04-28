class Solution {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        // 常量数组 控制上下左右方向
        val dx = intArrayOf(0,0,1,-1)
        val dy = intArrayOf(-1,1,0,0)

        // 矩阵的长宽
        val x = matrix.size
        val y = matrix[0].size

        // 标记[x,y]是否已访问
        var visited = Array(x, {BooleanArray(y)})
        // 队列
        val queue: Queue<IntArray> = LinkedList<IntArray>()

        // 把0全部入队，且标记为已访问
        for(i in 0 until x) {
            for(j in 0 until y) {
                if(matrix[i][j] == 0) {
                    // 0本身到最近的0的距离就是0，所以最开始的队列里的坐标值即“到最近的0的距离”
                    queue.add(intArrayOf(i, j))
                    visited[i][j] = true
                }
            }
        }
        
        // 结果矩阵
        var res = Array(x, {IntArray(y)}) //[2,3]

        // 队列不为空就一直循环
        while(!queue.isEmpty()) {
            // 从队列里取出一对坐标作为原始坐标[x,y]
            val org = queue.poll()
            val orgX = org[0]
            val orgY = org[1]

            // 遍历原始坐标[x,y]上下左右的坐标
            for(i in 0 until 4) {
                // 当前坐标
                val newX = orgX + dx[i]
                val newY = orgY + dy[i]

                // 坐标越界就跳过
                if(newX<0 || newX>=x || newY<0 || newY>=y || visited[newX][newY])
                    continue
                
                // 当前坐标到最近的0的距离就等于原始坐标的值（即：到最近的0的距离）+1
                res[newX][newY] = res[orgX][orgY] + 1;
                // 把当前坐标加入到队列里并标记已访问
                queue.add(intArrayOf(newX, newY));
                visited[newX][newY] = true;
            }
        }
        // 返回结果矩阵即可
        return res
    }
}