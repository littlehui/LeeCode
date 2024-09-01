package com.lilhui.leecode.linklist;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/02 12:51
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
