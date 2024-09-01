package com.lilhui.leecode.linklist;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/02 14:14
 */
public class ReverseList {

    /**
     *     //缓存一下next
     *             ListNode nextNode = currentNode.next;
     *             //翻转一下指针到preNode
     *             currentNode.next = preNode;
     *             //preNode后移一位
     *             preNode = currentNode;
     *             //跳到下一个
     *             currentNode = nextNode;
     * @param head
     * @author littlehui
     * @date 2024/8/2 15:19
     * @return com.lilhui.leecode.linklist.ListNode
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }


    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1, null);
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(3, null);
        ListNode node3 = new ListNode(4, null);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        head = reverseList.reverseList(head);
        while(head!= null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
