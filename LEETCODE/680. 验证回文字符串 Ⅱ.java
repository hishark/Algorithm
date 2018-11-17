class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            //不相等的话就不是回文啦！然后就删除i或者j判断是不是回文就好了！有一个是就够了！
            if(s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i+1,j)||isPalindrome(s,i,j-1);
            }else{//相等的话就继续往中间查询
                i++;
                j--;
            }
        }
        return true;
        
    }
    
    //判断一个字符串是不是回文串
    private boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}