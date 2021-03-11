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
        // 遍历字符串
        for(int i=0;i<s.length();i++){
            // 当前括号
            char c = s.charAt(i);
            // 若为右括号
            if(mapping.containsKey(c)){
                // 取出栈顶元素判断情况
                // 如果为空就用 # 标记
                char topElement = stack.empty() ? '#' : stack.pop();
                // 判断是否匹配，不匹配就返回 false
                if(topElement != mapping.get(c)){
                    return false;
                }
            }else{
                //若为左括号，直接全部扔到栈里
                stack.push(c);
            }
        }
        // 如果为空就说明字符串有效，不为空说明还有括号未匹配，那么字符串就是无效的
        return stack.empty();
    }
}
