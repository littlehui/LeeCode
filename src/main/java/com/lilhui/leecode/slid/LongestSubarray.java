package com.lilhui.leecode.slid;

/**
 * 删掉一个元素后全为1的最长子数组
 *
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 要么是 0 要么是 1 。
 *
 * @author littlehui
 * @date 2024/9/9 20:17
 * @version 1.0
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int k = 1;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += (1 - nums[right]);
            if (nums[right] == 0) {
                ans = right + 1;
            }
            while (lsum < rsum - k) {
                lsum += (1 - nums[left]);
                ++left;
            }
        }
        return ans;
    }
}
