package org.example.leetcode.problems;

import org.example.leetcode.common.ListNode;

/**
 * @author Marcoo
 * @description
 * @date 2022-05-15 9:33
 */
public class Demo206 {

    /**
     * 递归版
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }

    /**
     * 迭代版
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode node = pre.next;
            pre.next = cur;
            cur = pre;
            pre = node;
        }
        return cur;
    }
}
