package com.lilhui.leecode.slid;


/**
 * 1004.最大连续1的个护 III
 *
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 *
 * @author littlehui
 * @date 2024/9/9 17:08
 * @version 1.0
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int reverseNum = k;
        int result = 0;
        for (int i = 0,j = 0; j < nums.length && i < nums.length; j++) {
            if (nums[j] == 0) {
                if (--reverseNum < 0) {
                    //翻转次数用完
                    result = Math.max(result, j - i);
                    //找到0
                    if (nums[i] == 0) {
                        //找到1
                        while (nums[i] == 0) {
                            if (i == (nums.length - 1)) {
                                break;
                            }
                            i++;
                            reverseNum++;
                            reverseNum = Math.min(k, reverseNum);
                            j = Math.max(j, i);

                        }
                    } else {
                        //找到下一个0
                        while (nums[i++] == 1) {
                        }
                        reverseNum++;
                    }
                }
            } else {
                if (j == nums.length - 1) {
                    result = Math.max(result, j - i + 1);
                } else {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    /**
     * 题解
     * @param nums
     * @param k
     * @author littlehui
     * @date 2024/9/9 19:54
     * @return int
     */
    public int longestOnes1(int[] nums, int k) {
        int n = nums.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; ++right) {
            int left = binarySearch(P, P[right + 1] - k);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int binarySearch(int[] P, int target) {
        int low = 0, high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * 滑动窗口
     *
     * 对于数组 A 的区间 [left,right] 而言，只要它包含不超过 k 个 0，我们就可以根据它构造出一段满足要求，并且长度为 right−left+1 的区间。
     *
     * 因此，我们可以将该问题进行如下的转化，即：
     *
     * 对于任意的右端点 right，希望找到最小的左端点 left，使得 [left,right] 包含不超过 k 个 0。
     *
     * 只要我们枚举所有可能的右端点，将得到的区间的长度取最大值，即可得到答案。
     *
     * 要想快速判断一个区间内 0 的个数，我们可以考虑将数组 A 中的 0 变成 1，1 变成 0。此时，我们对数组 A 求出前缀和，记为数组 P，那么 [left,right] 中包含不超过 k 个 1（注意这里就不是 0 了），当且仅当二者的前缀和之差：
     *
     * P[right]−P[left−1]
     * 小于等于 k。这样一来，我们就可以容易地解决这个问题了。
     *
     *
     *
     * 方法二：滑动窗口
     * 思路与算法
     *
     * 我们继续观察 (1) 式，由于前缀和数组 P 是单调递增的，那么 (1) 式的右侧 P[right]−k 同样也是单调递增的。因此，我们可以发现：
     *
     * 随着 right 的增大，满足 (1) 式的最小的 left 值是单调递增的。
     *
     * 这样一来，我们就可以使用滑动窗口来实时地维护 left 和 right 了。在 right 向右移动的过程中，我们同步移动 left，直到 left 为首个（即最小的）满足 (1) 式的位置，此时我们就可以使用此区间对答案进行更新了。
     *
     * 细节
     *
     * 当我们使用滑动窗口代替二分查找解决本题时，就不需要显式地计算并保存出前缀和数组了。我们只需要知道 left 和 right 作为下标在前缀和数组中对应的值，因此我们只需要用两个变量 lsum 和 rsum 记录 left 和 right 分别对应的前缀和即可。
     *
     *
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/max-consecutive-ones-iii/solutions/608931/zui-da-lian-xu-1de-ge-shu-iii-by-leetcod-hw12/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @author littlehui
     * @date 2024/9/9 19:56
     * @return int
     */
    public int longestOnes3(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += (1 - nums[right]);
            while (lsum < rsum - k) {
                lsum += (1 - nums[left]);
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestOnes longestOnes = new LongestOnes();
        int[] bits = new int[]{1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        System.out.println(longestOnes.longestOnes1(bits,8));
    }
}
