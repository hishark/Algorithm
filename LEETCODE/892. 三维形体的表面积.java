class Solution {
    public int surfaceArea(int[][] grid) {
        //每个格子上的长方体面积=上下表面+每个正方体的四个侧面
        //最终形态的表面积=所有长方体的表面积-相邻柱体的贴合面积
        int x = grid[0].length;
        int y = grid.length;
        int area = 0;
        int cut = 0;

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                //针对每一个柱体，柱体所在的x坐标为i，y坐标为j
                //柱体由num个正方体组成
                int num = grid[i][j];
                //存在正方体才要算，不存在直接跳过（这个判断省了很多时间！！）
                if(num>0){
                    //上下表面积和侧面积
                    area += 2;
                    area += num*4;
                    //求解贴合面积，算i-1和j-1即可
                    if(i>0){
                        int diff = Math.min(grid[i][j], grid[i-1][j]);
                        cut += diff*2;
                    }
                    if(j>0){
                        int diff = Math.min(grid[i][j], grid[i][j-1]);
                        cut += diff*2;
                    }
                }
            }
        }
        return area-cut;

    }
}