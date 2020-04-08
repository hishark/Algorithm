class Solution {
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];//default value: false
        return dfs(0, 0, k);
    }
    public int dfs(int x, int y, int k){
        //all digit
        int i = x;
        int j = y;
        int sum = 0;
        while(x!=0||y!=0){
            sum += x%10;
            sum += y%10;
            x /= 10;
            y /= 10;
        }
        if(sum>k || i>=visited.length || j>=visited[0].length || i<0 || j<0 || visited[i][j]==true){
            return 0;
        }
        visited[i][j] = true;
        //不需要访问上下左右，只需要访问右和下即可。所以下面注释的两行可要可不要，都可以ac
        return 1 + dfs(i+1, j, k)
                //  + dfs(i-1, j, k)
                //  + dfs(i, j-1, k)
                 + dfs(i, j+1, k);
    }
}