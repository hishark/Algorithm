class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hashset = new HashSet<Integer>();//HashSet不允许集合中出现重复元素
        while(true){
            int newN = 0;
            while(n!=0){
                int num = n%10;
                newN += Math.pow(num,2);
                n /= 10;
            }
            n = newN;
            if(n==1)
                return true;
            else if(!hashset.add(n))
                return false;
        }
        
    }
}

