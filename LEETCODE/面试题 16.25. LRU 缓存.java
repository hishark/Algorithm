class LRUCache extends LinkedHashMap<Integer, Integer>{
    // 最大容量
    private int capacity;
    
    // 初始化
    public LRUCache(int capacity) {
        // size > capacity * 0.75 的时候就扩容
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    // 有就返回值，没有就返回-1
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 放入值
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}
