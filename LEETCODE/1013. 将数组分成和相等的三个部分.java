class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i:A){
            sum += i;
        }
        if(sum%3!=0){
            return false;
        }

        int target = sum / 3;
        int curSum = 0;
        //遍历A数组，加到第一个等于sum/3的位置，记录下i，如果没有这个i，返回false
        //如果有这个i，继续加，找到（sum/3） * 2，记录下j，如果没有j，返回false
        //如果有这个j，直接返回true。

        int i = 0, n = A.length;
        while(i<n){
            curSum += A[i];
            if(curSum == target){
                break;
            }
            i++;
        }
        int j = i + 1;
        while(j+1<n){//确保最后不是一个空数组
            curSum += A[j];
            if(curSum == target * 2){
                return true;
            }
            j++;
        }
        return false;
    }
}