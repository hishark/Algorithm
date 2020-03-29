//常量增量数组dx={0,0,1,-1} dy={1,-1,0,0}
//天天靠甜姨拉扯长大🍬
//https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
class Solution {
    public int maxDistance(int[][] grid) {
        //常量增量数组
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //陆地队列
        Queue<int[]> queue = new ArrayDeque<>();
        int row = grid.length;
        int column = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]==1){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //第一个陆地出列
        int[] current = null;
        //是否存在海洋
        boolean hasOcean = false;
        //只要陆地队列不为空就一直扩散下去
        while(!queue.isEmpty()){
            current = queue.poll();
            //扩散到上下左右四个方向
            for(int i=0;i<4;i++){
                int x = current[0];
                int y = current[1];
                //扩散的陆地坐标
                int newX = x + dx[i];
                int newY = y + dy[i];
                //对该坐标进行判断
                //如果该坐标不是海洋，或者超出地图范围，就continue
                //注意不要写成grid==1,因为之后对grid内的数字进行了递增,仅当不为0时才是陆地
                if(newX<0 || newX>=column || newY<0 || newY>=row || grid[newX][newY]!=0){
                    continue;
                }
                hasOcean = true;
                //别写成+=1了，是grid[x][y] + 1，最后要取这个值
                grid[newX][newY] = grid[x][y] + 1;
                //记得入队
                queue.offer(new int[]{newX, newY});
            }
        }

        //如果没有海洋or没有陆地，返回-1
        if(!hasOcean || current==null){
            return -1;
        }
        //返回最后抵达的海洋的值，即为最远的距离
        return grid[current[0]][current[1]] - 1;
    }
}
