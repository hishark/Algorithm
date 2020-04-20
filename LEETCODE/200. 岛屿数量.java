//Medium
class Solution {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int x = grid.length;
        int y = grid[0].length;
        int ans = 0;

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(grid[i][j]=='1'){
                    //岛个数+1
                    ans++;
                    //搜索这个岛周边的所有岛，加上自己全部设置为0
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    public void dfs(int x, int y, char[][] grid) {
        //别忘记grid[x][y]=='0'，不然会stackoverflow
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]=='0') {
            return;
        }
        grid[x][y] = '0';
        dfs(x-1, y, grid);
        dfs(x+1, y, grid);
        dfs(x, y-1, grid);
        dfs(x, y+1, grid);
    }
}