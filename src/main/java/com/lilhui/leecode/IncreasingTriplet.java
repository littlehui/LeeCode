package com.lilhui.leecode;

/**
 *
 * 334.递归的三元子序列
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/09/01 22:37
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first){
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
