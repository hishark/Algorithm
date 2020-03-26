class Solution {
    public int numRookCaptures(char[][] board) {
        int board_x = board[0].length;
        int board_y = board.length;
        //上下左右四个方向
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int ans = 0;
        for(int i=0;i<board_x;i++){
            for(int j=0;j<board_y;j++){
                //找到车之后就开始上下左右找象/卒
                if(board[i][j]=='R'){
                    for(int k=0;k<4;k++){
                        int x = i, y = j;
                        while(true){
                            //平移坐标
                            x+=dx[k];
                            y+=dy[k];
                            //判断平移后的坐标上是否超过了棋盘/是否是象
                            if(x<0||x>=board_x||y<0||y>=board_y||board[x][y]=='B'){
                                break;
                            }
                            //如果平移后的坐标上是卒
                            if(board[x][y]=='p'){
                                ans++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
////////////////////////////////////////////////////////////////////////////////////
//这样写也没错，而且执行时间也很短。但是这样子判断上下左右太蠢了，改成使用数组进行坐标平移就好很多。
class Solution {
    public int numRookCaptures(char[][] board) {
        int board_x = board[0].length;
        int board_y = board.length;
        int rook_x = 0, rook_y = 0;
        int ans = 0;
        for(int i=0;i<board_x;i++){
            for(int j=0;j<board_y;j++){
                //找到车就记下位置
                if(board[i][j]=='R'){
                    rook_x = i;
                    rook_y = j;
                }
            }
        }

        //从四个方向做判断
        //向上
        boolean bishop = false;
        for(int y=rook_y;y>0;y--){
            if(board[rook_x][y]=='B'){
                bishop = true;
            }
            if(bishop){
                break;
            }else{
                if(board[rook_x][y]=='p'){
                    ans++;
                    break;
                }
            }
        }
        //向下
        bishop = false;
        for(int y=rook_y;y<board_y;y++){
            if(board[rook_x][y]=='B'){
                bishop = true;
            }
            if(bishop){
                break;
            }else{
                if(board[rook_x][y]=='p'){
                    ans++;
                    break;
                }
            }
        }
        //向左
        bishop = false;
        for(int x=rook_x;x>0;x--){
            if(board[x][rook_y]=='B'){
                bishop = true;
            }
            if(bishop){
                break;
            }else{
                if(board[x][rook_y]=='p'){
                    ans++;
                    break;
                }
            }
        } 
        //向右
        bishop = false;
        for(int x=rook_x;x<board_x;x++){
            if(board[x][rook_y]=='B'){
                bishop = true;
            }
            if(bishop){
                break;
            }else{
                if(board[x][rook_y]=='p'){
                    ans++;
                    break;
                }
            }
        } 
        return ans;
    }
}