package leetcode.problem146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node tailNode = tail.pre;
        removeNode(tailNode);
        return tailNode;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int v1 = lRUCache.get(1);// 返回 1
        System.out.println(v1);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        int v2 = lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println(v2);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        int v3 = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(v3);
        int v4 = lRUCache.get(3);    // 返回 3
        System.out.println(v4);
        int v5 = lRUCache.get(4);    // 返回 4
        System.out.println(v5);

    }
}
