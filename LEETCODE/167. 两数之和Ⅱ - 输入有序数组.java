class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum==target){
                //记得加一，按题意index从1开始
                return new int[]{i+1,j+1};
            } else if(sum<target){
                //和小了，那就加数大一点
                i++;
            }else{
                //和大了，那就加数小一点
                j--;
            }
        }
        //这句也不能丢
        return null;
    }
}