package com.lilhui.leecode.linklist;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/02 12:51
 */
public class DeleteMiddle {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode startNode = head;
        while(startNode != null) {
            size ++;
            startNode = startNode.next;
        }
        if (size == 1) {
            return null;
        }
        startNode = head;
        int middle = size/2 + 1;
        int current = 1;
        while(startNode!= null) {
            current++;
            if (current == middle) {
                ListNode currentNode = startNode.next;
                ListNode nextNode = startNode.next.next;
                startNode.next = nextNode;
                currentNode = null;
                break;
            }
            startNode = startNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteMiddle deleteMiddle = new DeleteMiddle();
        ListNode head = new ListNode(1, null);
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(3, null);
        ListNode node3 = new ListNode(4, null);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        deleteMiddle.deleteMiddle(head);
        while(head!= null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
