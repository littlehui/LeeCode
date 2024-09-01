package com.lilhui.leecode.linklist;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/02 13:34
 */
public class OddEvenList {

   public ListNode oddEvenList(ListNode head) {
      if (head == null) {
         return null;
      }
      if (head.next == null || head.next.next == null) {
         return head;
      }
      ListNode startONode = new ListNode(0, null);
      ListNode currentONode = startONode;
      ListNode startJNode = new ListNode(0, null);
      ListNode currentJNode = startJNode;

      boolean oIndexFlag = true;
      while (head != null) {
         if (oIndexFlag) {
            currentONode.next = new ListNode(head.val, null);
            currentONode = currentONode.next;
            oIndexFlag = false;
         } else {
            currentJNode.next = new ListNode(head.val, null);
            currentJNode = currentJNode.next;
            oIndexFlag = true;
         }
         head = head.next;
      }
      currentONode.next = startJNode.next;
      return startONode.next;
   }

   public static void main(String[] args) {
      OddEvenList oddEvenList = new OddEvenList();
      ListNode head = new ListNode(1, null);
      ListNode node1 = new ListNode(2, null);
      ListNode node2 = new ListNode(3, null);
      ListNode node3 = new ListNode(4, null);

      head.next = node1;
      node1.next = node2;
      node2.next = node3;

      head = oddEvenList.oddEvenList(head);
      while(head!= null) {
         System.out.print(head.val);
         head = head.next;
      }
   }
}
