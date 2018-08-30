class MySolution {
    public String reverseString(String s) {
        StringBuffer test = new StringBuffer(s);
        test.reverse();
        s = new String(test);
        return s;
    }
}