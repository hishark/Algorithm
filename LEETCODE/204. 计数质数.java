//Easy
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        //初始化为true
        Arrays.fill(isPrim, true);
        //result
        int res = 0;

        for(int i=2;i<n;i++){
            //如果i是质数，那么i的倍数一定不是质数了
            if(isPrim[i]){
                //j就是i+i+i+i+i+...
                for(int j=i+i;j<n;j+=i){
                    isPrim[j] = false;
                }
            }
        }

        //再遍历一边计算质数的个数
        for(int i=2;i<n;i++){
            if(isPrim[i])
                res++;
        }
        
        return res;
    }
}