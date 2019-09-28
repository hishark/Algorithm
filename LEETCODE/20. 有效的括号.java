class Solution {
    
    private HashMap<Character, Character> mapping;
    
    public Solution(){
        //记得初始化
        this.mapping = new HashMap<Character, Character>();
        this.mapping.put(')', '(');
        this.mapping.put(']', '[');
        this.mapping.put('}', '{');
    }
    public boolean isValid(String s) {
        //栈可以用来灵活解决递归结构的问题
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(mapping.containsKey(c)){
                //若为右括号，取出栈顶元素判断情况
                char topElement = stack.empty()?'#':stack.pop();
                if(topElement!=mapping.get(c)){
                    return false;
                }
            }else{
                //若为左括号，全部扔到栈里
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
