package org.example.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description LFU缓存   https://leetcode-cn.com/problems/lfu-cache/
 * @Author Marcoo
 * @Date 2020/4/5 13:06
 */
public class LFUCache {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

    private int size;
    private int capacity;
    private Map<Integer, ListNode> valueMap;
    private Map<Integer, DoubleLinkedList> freqMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>(capacity);
        freqMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (capacity < 1) {
            return -1;
        }

        ListNode valueNode = valueMap.get(key);
        if (valueNode == null) {
            return -1;
        }
        int value = valueNode.value;
        moveNode(valueNode);
        return value;
    }

    public void put(int key, int value) {
        if (capacity < 1) {
            return;
        }

        ListNode valueNode = valueMap.get(key);
        if (valueNode != null) {
            valueNode.value = value;
            moveNode(valueNode);
            return;
        }
        // 缓存已满，需要进行删除操作
        if (size == capacity) {
            int freq = 1;
            while (true) {
                DoubleLinkedList list = freqMap.get(freq);
                if (list != null && list.size > 0) {
                    ListNode deleteNode = list.removeTail();
                    valueMap.remove(deleteNode.key);
                    size--;
                    break;
                }
                freq++;
            }
        }

        ListNode node = new ListNode(key, value);
        node.freq = 1;
        moveToListHead(node);

        valueMap.put(key, node);
        size++;
    }

    private void moveNode(ListNode valueNode) {
        removeNodeFromOriginFreq(valueNode);
        moveToListHead(valueNode);
    }

    private void moveToListHead(ListNode valueNode) {
        int freq = valueNode.freq;
        DoubleLinkedList list = freqMap.get(freq);
        if (list == null) {
            list = new DoubleLinkedList();
            freqMap.put(freq, list);
        }
        list.addHead(valueNode);
    }

    /**
     * 在原来的访问频率链表中删除 node
     * @param deleteNode
     */
    private void removeNodeFromOriginFreq(ListNode deleteNode) {
        ListNode pre = deleteNode.pre;
        ListNode next = deleteNode.next;
        pre.next = next;
        next.pre = pre;
        deleteNode.pre = null;
        deleteNode.next = null;

        freqMap.get(deleteNode.freq).size--;
        deleteNode.freq++;
    }

    /**
     * 双向链表
     */
    public static class DoubleLinkedList {
        ListNode head = new ListNode();
        ListNode tail = new ListNode();
        int size;

        public void addHead(ListNode node) {
            if (head.next == null) {
                head.next = node;
                tail.pre = node;
                node.pre = head;
                node.next = tail;
                size++;
                return;
            }
            ListNode oldFirst = head.next;
            head.next = node;
            oldFirst.pre = node;
            node.pre = head;
            node.next = oldFirst;
            size++;
        }

        public ListNode removeTail() {
            ListNode deleteNode = tail.pre;
            ListNode pre = deleteNode.pre;
            tail.pre = pre;
            pre.next = tail;
            deleteNode.pre = null;
            deleteNode.next = null;
            size--;
            return deleteNode;
        }
    }

    /**
     * 双向链表节点
     */
    public static class ListNode {
        int key;
        // 需要被返回的值
        int value;
        // 访问频率计数
        int freq;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {
        }
    }
}
