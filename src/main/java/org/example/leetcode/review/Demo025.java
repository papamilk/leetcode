package org.example.leetcode.review;

import org.example.leetcode.common.ListNode;

/**
 * @author Marcoo
 * @description
 * @date 2022-06-06 20:37
 */
public class Demo025 {

    public static void main(String[] args) {
        int[] arr = {1, 2};
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            ListNode subTail = pre;
            for (int i = 0; i < k; i++) {
                subTail = subTail.next;
                if (subTail == null) {
                    return dummy.next;
                }
            }
            ListNode nexNext = subTail.next;
            ListNode[] reverse = reverseGroup(head, subTail);
            head = reverse[0];
            subTail = reverse[1];
            pre.next = head;
            subTail.next = nexNext;
            pre = subTail;
            head = nexNext;
        }
        return dummy.next;
    }

    public static ListNode[] reverseGroup(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}
