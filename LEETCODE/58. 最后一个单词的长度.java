//投机取巧
class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==0||s.split(" ").length==0)
            return 0;
        return s.split(" ")[s.split(" ").length-1].length();
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while(end>=0 && s.charAt(end)==' ') 
            end--;
        if(end<0) 
            return 0;
        int start = end;
        while(start>=0 && s.charAt(start)!=' ')
            start--;
        //这里s.charAt(start)!=' '不能写在前面，因为while会从左到右进行判断，start<0会导致charAt报错。
        // while(s.charAt(start)!=' ' && start>=0)
        //     start--;
        return end-start;
    }
}
