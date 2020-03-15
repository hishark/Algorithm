//深度优先搜索dfs
class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
         int maxCount=0;

         for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){ 
                 //虽然dfs里面有对1的判断，但是这里也判断一下的话，可以减少搜索次数
                if(grid[i][j]==1){
                    maxCount=Math.max(maxCount, dfs(grid,i,j)); 
                }            
             }
         }
         return maxCount;
    }

    //返回第row行第column列的数字的岛屿数
    public int dfs(int[][] grid, int row, int column){        
        //如果坐标不合法，直接返回
        if(row<0||row>=grid.length||column<0||column>=grid[0].length){
            return 0;
        }

        //如果不是岛屿，或者已经访问过了，也返回
        //不是岛屿:0，是岛屿:1，是访问过的岛屿:2
        if(grid[row][column]!=1){
            return 0;
        }

        //到了这一定是个还没标记过的岛啦
        //如果是没有访问过的岛屿，先标记为2，然后访问上下左右，加上自己的1即可
        grid[row][column]=2;
        int up = dfs(grid, row-1, column);//上一行
        int down = dfs(grid, row+1, column);//下一行
        int left = dfs(grid, row, column-1);//上一列
        int right =dfs(grid, row, column+1);//上一列
        return 1+up+down+left+right;
    }
}