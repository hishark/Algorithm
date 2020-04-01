//这个题目真的是有点啰嗦哈
//https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solution/qian-tao-shen-du-wan-cheng-gua-hao-pi-pei-wen-ti-s/
//weiwei这次的题解写的很清楚奥
//连续的 (会造成嵌套深度的增加，因此对于这种要把他们分到不同的组中。而连续的标准不仅仅是原始字符串中的左右相邻，应该还包括中间成对的 （）消除后的连续。
//——————来自题解评论区
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] res = new int[length];
        //字符数组
        char[] ch = seq.toCharArray();
        //嵌套的深度
        int depth = 0;
        
        for(int i=0;i<length;i++){
            //遍历到左括号，入栈
            if(ch[i]=='('){
                depth++;
                res[i] = depth % 2;                
            }else{
                //遍历到右括号，该右括号和此时的栈顶左括号配对
                res[i] = depth % 2;
                //配对的右括号出栈，嵌套深度减1
                depth--;
            }
        }
        return res;
    }
}