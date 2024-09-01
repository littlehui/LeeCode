package com.lilhui.leecode.linklist;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/02 15:30
 */
public class PairSum {

   public int pairSum(ListNode head) {
      if (head == null) {
         return 0;
      }
      Stack<Integer> stack = new Stack<>();
      Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
      Integer parSum = 0;
      Integer size = 0;
      ListNode countNode = head;
      while (countNode != null) {
         size++;
         countNode = countNode.next;
      }
      Integer middle = size/2;
      for (int i = 0; i< size; i++) {
         if (i>(middle-1)) {
            stack.push(head.val);
         } else {
            queue.add(head.val);
         }
         head = head.next;
      }
      for (int i=0; i<middle; i++) {
         parSum = Math.max(stack.pop() + queue.poll(), parSum);
      }
      return parSum;
   }

   public static void main(String[] args) {
      PairSum pairSum = new PairSum();
      ListNode head = new ListNode(1, null);
      ListNode node1 = new ListNode(2, null);
      ListNode node2 = new ListNode(3, null);
      ListNode node3 = new ListNode(4, null);

      head.next = node1;
      node1.next = node2;
      node2.next = node3;

      System.out.println(pairSum.pairSum(head));
   }
}
