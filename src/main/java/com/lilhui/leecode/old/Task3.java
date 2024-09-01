package com.lilhui.leecode.old;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/14 21:30
 */
public class Task3 {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int core = 0;
      int taskCount = 0;
      core = Integer.parseInt(in.nextLine());
      taskCount = Integer.parseInt(in.nextLine());
      String taskStrs = in.nextLine();
      int[] tasks = new int[taskCount];
      String[] taskArray = taskStrs.split(" ");
      Queue<Integer> queue = new LinkedBlockingQueue<>();
      for (int i=0; i<taskArray.length; i++) {
         int taskItems = Integer.parseInt(taskArray[i]);
         for (int j=0;j<taskItems;j++) {
            queue.add(i+1);
         }
      }
      System.out.println(runTime(core, taskCount, queue));
   }

   public static int runTime(int core, int taskCount, Queue<Integer> queue) {
      int runTimes = 0;
      int preTask = 1;
      while (!queue.isEmpty()) {
         boolean canNext = true;
         for (int i=0;i<core;i++) {
            if (queue.isEmpty()) {
               break;
            }
            int currentTask = queue.peek();
            if (currentTask != preTask) {
               canNext = false;
               preTask = currentTask;
               break;
            } else {
               preTask = currentTask;
               queue.poll();
            }
         }
         if (!queue.isEmpty()) {
            preTask = queue.peek();
         }
         runTimes++;
      }
      return runTimes-1;
   }
}
