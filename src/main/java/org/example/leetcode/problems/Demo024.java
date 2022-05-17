package org.example.leetcode.problems;

import org.example.leetcode.common.ListNode;

/**
 * @author Marcoo
 * @description
 * @date 2022-05-15 8:02
 */
public class Demo024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
