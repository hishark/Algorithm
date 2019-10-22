class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        if(numRows==0){
            return triangle;//0就返回空list咯
        }
        
        //第一行永远是1
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        
        //按行加
        for(int i=1;i<numRows;i++){
            //每一行都是一个List
            List<Integer> curRow = new ArrayList<Integer>();
            //第一个数一定是1
            curRow.add(1);
            //中间的数都是上面的相加
            for(int j=1;j<i;j++){
                curRow.add(triangle.get(i-1).get(j)+triangle.get(i-1).get(j-1));
            }
            //最后一个数一定是1
            curRow.add(1);
            //记得加
            triangle.add(curRow);
        }
        return triangle;
    }
}
