package com.lilhui.leecode.old;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/14 21:30
 */
public class Task2 {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      while (in.hasNext()) {
         int core = in.nextInt();
         int taskCount = in.nextInt();
         int runTime = 0;
         int coreRemain = 0;
         Queue<Integer> queue = new LinkedBlockingQueue<>();

         for (int i=0;i<taskCount;i++) {
            int taskItemCount = in.nextInt();
            for (int j= 0;j<taskItemCount;j++) {
               queue.add(i+1);
            }
            }
            for (int k=0;k<core;k++) {
               queue.poll();
            runTime++;
         }
         while (!queue.isEmpty()) {
            for (int k=0;k<core;k++) {
               queue.poll();
            }
            runTime++;
         }
         System.out.println(runTime);
      }
   }
}
