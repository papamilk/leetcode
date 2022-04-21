package org.example.leetcode.problems;

import org.example.leetcode.common.ListNode;

/**
 * @Description 合并两个有序链表    https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Author Marcoo
 * @Date 2022-04-21 21:31
 */
public class Demo021 {

    /**
     * 递归算法最简单
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
}
