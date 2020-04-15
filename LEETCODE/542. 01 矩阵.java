/**
 * Reference:
 * https://leetcode-cn.com/problems/01-matrix/solution/java-jian-dan-de-bfs-by-kelly2018/
 * 
 * BFS
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        int x = matrix.length;
        int y = matrix[0].length;
        boolean[][] visited = new boolean[x][y];
        Queue<int[]> queue = new LinkedList<>();
        //0全部入队，且标记为已访问
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        //result
        int[][] res = new int[x][y];

        //队列不为空时
        while(!queue.isEmpty()){
            int[] d = queue.poll();
            int orgX = d[0];
            int orgY = d[1];
            for(int i=0;i<4;i++){
                int newX = orgX + directions[i][0];
                int newY = orgY + directions[i][1];
                if(newX<0 || newX>=x || newY<0 || newY>=y || visited[newX][newY])
                    continue;
                res[newX][newY] = res[orgX][orgY] + 1;
                queue.offer(new int[]{newX, newY});
                visited[newX][newY] = true;
            }
        }

        return res;
    }
}