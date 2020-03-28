//字典树 不会
//甜姨👍
//https://leetcode-cn.com/problems/short-encoding-of-words/solution/99-java-trie-tu-xie-gong-lue-bao-jiao-bao-hui-by-s/
//Arrays.sort() https://stackoverflow.com/questions/21970719/java-arrays-sort-with-lambda-expression
//-> https://www.runoob.com/java/java8-lambda-expressions.html
class Solution {
    public int minimumLengthEncoding(String[] words) {
        //先把字符串从长到短进行排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        //初始化长度
        int len = 0;
        //初始化字典树
        Trie trie = new Trie();
        //遍历插入，更新长度
        for(String s:words){
            len += trie.insert(s);
        }
        return len;
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public int insert(String word){
        int length = 0;
        TrieNode cur = root;
        //是否是新单词
        boolean isNew = false;
        //倒着插入.别写成i>0了
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            int index = c - 'a';
            //如果当前根结点的所有子节点中没有c字符，就插入c字符
            if(cur.children[index]==null){
                //不存在字符c，说明是一个新串
                isNew = true;
                cur.children[index] = new TrieNode(c);
            }
            cur = cur.children[index];
        }
        return isNew ? word.length()+1 : 0;
    }
}

class TrieNode{
    //根结点的值
    char val;
    //子节点 
    TrieNode[] children = new TrieNode[26];
    //构造方法
    public TrieNode(){}
    public TrieNode(char val){
        this.val = val;
    }
    
}