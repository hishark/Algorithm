class Solution {
    public int addDigits(int num) {
        while(true){
            int sum = 0;
            while(num!=0){
                sum += num%10;
                num /= 10;
            }
            if(sum<10){
                return sum;
            }else{
                num = sum;
            }
        }
    }
}