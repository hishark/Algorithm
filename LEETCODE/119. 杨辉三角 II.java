//整个杨辉三角都保存下来
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
      
        //第一行永远是1
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        
        for(int i=1;i<=rowIndex;i++){
            List<Integer> curRow = new ArrayList<Integer>();
            //第一个数字永远是1
            curRow.add(1);
            for(int j=1;j<i;j++){
                curRow.add(triangle.get(i-1).get(j)+triangle.get(i-1).get(j-1));
            }
            //最后一个数字是1
            curRow.add(1);
            //又把这一行给忘了！！
            triangle.add(curRow);
        }
        
        return triangle.get(rowIndex);
    }
}

//只保存上一行
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
            cur = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    cur.add(1);
                }else{
                    cur.add(pre.get(j)+pre.get(j-1));
                }
            }
            pre = cur;
        }
        return cur;
    }
}
