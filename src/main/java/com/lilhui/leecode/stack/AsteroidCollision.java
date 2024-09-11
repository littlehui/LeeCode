package com.lilhui.leecode.stack;

import java.util.Stack;

/**
 * 735.小行星碰撞
 *
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 *
 *示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 *
 * @author littlehui
 * @date 2024/9/10 17:19
 * @version 1.0
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (i == 0) {
                stack.push(asteroids[i]);
            } else {
                int preInt = stack.peek();
                if (preInt < 0) {
                    if (asteroids[i] < 0) {
                        stack.push(asteroids[i]);
                    } else {
                        //处理碰撞
                        if (Math.abs(asteroids[i]) == Math.abs(preInt)) {
                            stack.pop();
                        }
                        if (Math.abs(preInt) - Math.abs(asteroids[i]) < 0) {
                            stack.pop();
                            //stack.push(asteroids[i]);
                            i--;
                        }
                    }
                } else {
                    //pre > 0
                    if (asteroids[i] > 0) {
                        stack.push(asteroids[i]);
                    } else {
                        //处理碰撞
                        if (Math.abs(asteroids[i]) == Math.abs(preInt)) {
                            stack.pop();
                        }
                        if (Math.abs(preInt) - Math.abs(asteroids[i]) < 0) {
                            stack.pop();
                            i--;
                        }
                    }
                }
            }
        }
        int[] resultInt = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            resultInt[index--] = stack.pop();
        }
        return resultInt;
    }

    /**
     * 方法一：栈模拟
     * 使用栈 st 模拟行星碰撞，从左往右遍历行星数组 asteroids，当我们遍历到行星 aster 时，使用变量 alive 记录行星 aster 是否还存在（即未爆炸）。
     *
     * 当行星 aster 存在且 aster<0，栈顶元素非空且大于 0 时，说明两个行星相互向对方移动：如果栈顶元素大于等于 −aster，则行星 aster 发生爆炸，将 alive 置为 false；如果栈顶元素小于等于 −aster，则栈顶元素表示的行星发生爆炸，执行出栈操作。重复以上判断直到不满足条件，如果最后 alive 为真，说明行星 aster 不会爆炸，则将 aster 入栈。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/asteroid-collision/solutions/1663442/xing-xing-peng-zhuang-by-leetcode-soluti-u3k0/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     * @author littlehui
     * @date 2024/9/10 17:55
     * @return void
     */
    public static void main(String[] args) {
        int[] coll = new int[]{-2,-1,1,2};
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] result = asteroidCollision.asteroidCollision(coll);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}
