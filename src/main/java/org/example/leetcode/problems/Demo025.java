package org.example.leetcode.problems;

import org.example.leetcode.common.ListNode;

/**
 * @author Marcoo
 * @description
 * @date 2022-05-15 9:07
 */
public class Demo025 {

    public static void main(String[] args) {
        int[] arr = {1};
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

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }


    public static ListNode[] reverseList(ListNode head, ListNode tail) {
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
