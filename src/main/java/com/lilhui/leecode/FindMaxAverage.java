package com.lilhui.leecode;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/23 22:15
 */
public class FindMaxAverage {

   public double findMaxAverage(int[] nums, int k) {
      double maxAvg = -Double.MAX_VALUE;
      for (int i = 0; i < nums.length - k + 1; i++) {
         int currentTotal = 0;
         for (int j = i; j < i + k; j++) {
            currentTotal += nums[j];
         }
         maxAvg = Math.max(maxAvg, (double) currentTotal/k);
      }
      return maxAvg;
   }

   public static void main(String[] args) {
      FindMaxAverage findMaxAverage = new FindMaxAverage();
      int[] nums = new int[]{-1};
      int k = 1;
      System.out.println(findMaxAverage.findMaxAverage(nums, k));
   }
}
