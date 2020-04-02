class Solution {
    public void gameOfLife(int[][] board) {
        //使用常量增量数组来模拟坐标的平移
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
        //复制数组copyBoard用于计算下一个状态
        int rows = board.length;
        int cols = board[0].length;
        int[][] copyBoard = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                copyBoard[i][j] = board[i][j];
            }
        }
        //遍历所有格子里的细胞
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                //当前细胞周围存活的细胞数量
                int liveCnt = 0;
                //遍历当前细胞周围的细胞
                for(int k=0;k<8;k++){
                    //周围细胞的坐标
                    int x = row + dx[k];
                    int y = col + dy[k];
                    //判断边界
                    if(x<0||x>=rows||y<0||y>=cols){
                        continue;
                    }
                    //判断该细胞的状态
                    if(copyBoard[x][y]==1){
                        liveCnt++;
                    }   
                }
                //计算结束后进行判断
                //Rule1
                if(copyBoard[row][col]==1 && liveCnt<2){
                    board[row][col] = 0;
                }
                //Rule3
                if(copyBoard[row][col]==1 && liveCnt>3){
                    board[row][col] = 0;
                }
                //Rule4
                if(copyBoard[row][col]==0 && liveCnt==3){
                    board[row][col] = 1;
                }
            }
        }
    }
}