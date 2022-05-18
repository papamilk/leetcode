package org.example.leetcode.problems;

import org.example.leetcode.common.ListNode;

/**
 * @author Marcoo
 * @description
 * @date 2022-05-15 9:07
 */
public class Demo025 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        ListNode listNode = reverseKGroup(head, 2);
        StringBuilder builder = new StringBuilder();
        while (listNode != null) {
            builder.append(listNode.val).append(", ");
            listNode = listNode.next;
        }
        System.out.println(builder);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curHead = head;
        ListNode pre = head;
        ListNode firstNode = head;
        ListNode curTail = null;
        boolean isHead = true;
        int count = 0;
        while (pre != null) {
            pre = pre.next;
            count++;
            if (count == k) {
                if (isHead) {
                    firstNode = reverseList(curHead, k, pre);
                    isHead = false;
                } else {
                    curTail.next = reverseList(curHead, k, pre);
                }
                curTail = curHead;
                curHead = pre;
                count = 0;
            }

        }
        return firstNode;
    }


    public static ListNode reverseList(ListNode head, int k, ListNode tail) {
        // 下一段链表赋值给head.next
        ListNode cur = tail;
        ListNode pre = head;
        int count = 0;
        while (pre != null && count < k) {
            ListNode node = pre.next;
            pre.next = cur;
            cur = pre;
            pre = node;
            count++;
        }
        return cur;
    }
}
