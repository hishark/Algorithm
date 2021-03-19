// 用linkedhashmap
class LRUCache extends LinkedHashMap<Integer, Integer> {
    // 容量
    private int capacity;

    // 构造函数
    public LRUCache(int capacity) {
        // 容量设置为 capacity，扩容因子为0.75，排序方式设置为按照访问顺序来排序
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    // 获得key对应的value
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 插入key-value
    // 已存在就更新value
    // 不存在就直接插入
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

// 不借助 linkedhashmap，自己实现
// LRU 缓存机制可以通过哈希表辅以双向链表实现
// 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
public class LRUCache {
    // 定义双向链表中的结点
    class DLinkedNode {
        // 键值对
        int key;
        int value;

        // 指向前一个结点
        DLinkedNode prev;
        // 指向下一个结点
        DLinkedNode next;

        // 构造函数
        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    // 哈希表 通过缓存数据的键（key）映射到其在双向链表中的位置
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    // 当前LRU的大小
    private int size;
    // LRU的容量限制
    private int capacity;
    // 双向链表的伪头尾结点
    private DLinkedNode head, tail;

    // 构造函数
    public LRUCache(int capacity) {
        // 初始化
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点，不存值
        head = new DLinkedNode();
        tail = new DLinkedNode();
        // 互相引用，连起来。
        // 这一步别忘记啦，不然双向链表都没成功初始化
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 从哈希表里抓key
        DLinkedNode node = cache.get(key);
        // 没抓到返回-1
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 把新结点放进哈希表存储起来
            cache.put(key, newNode);
            // 作为最新访问的结点，添加到双向链表的头部
            addToHead(newNode);
            // 双向链表长度++
            size++;
            // 此时判断一下是否超过了LRU的容量
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                // 双向链表长度--
                size--;
            }
            // 如果没有超过容量，啥也不用干
        } else {
            // 如果哈希表中已经存在key，就更新value
            node.value = value;
            // 并将该结点移动到双向链表的头部
            moveToHead(node);
        }
    }

    // 把结点加到双向链表的头部
    private void addToHead(DLinkedNode node) {
        // 把node插入到head和原来的head.next之间即可
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        // 这一段顺序以免搞错，这么记：node要拥抱左右的结点，先伸出了左手，再伸出了右手，然后node右边的结点先伸出了左手，node左边的结点最后伸出了右手。
    }

    // 删除node结点，让上一个结点next指向下一个结点，下一个结点的prev指向上一个结点即可
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 把结点移动到头部
    private void moveToHead(DLinkedNode node) {
        // 把node删掉
        removeNode(node);
        // 再加到表头
        addToHead(node);
    }

    // 移除尾部结点
    private DLinkedNode removeTail() {
        // 真正要删除的结点，是伪尾部的前一个结点
        DLinkedNode res = tail.prev;
        removeNode(res);
        // 返回即可
        return res;
    }
}

// ref:
// https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/