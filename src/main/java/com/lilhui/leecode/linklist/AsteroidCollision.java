package com.lilhui.leecode.linklist;

import java.util.Stack;

/**
 *
 * 735.小行星碰撞
 *
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
 * 每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两
 * 颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 *
 *
 * 示例 1：
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
 * 提示：
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/08/02 22:53
 */
public class AsteroidCollision {

   public int[] asteroidCollision(int[] asteroids) {
      Stack<Integer> aster = new Stack<>();
      for (int i=0; i<asteroids.length; i++) {
         Integer current = aster.peek();
         if (current != null) {
            int pengzhuang = 0;
            while ((pengzhuang = pengzhuang(current, asteroids[i])) != 0) {
               
               current = aster.peek();
            }
         } else {
            aster.push(asteroids[i]);
         }
      }
      return null;
   }

   public int pengzhuang(int a, int b) {
      if (a > 0) {
         if (b < 0) {
            if (a + b < 0) {
               return b;
            } else if (a + b == 0){
               return 0;
            } else {
               return a;
            }
         }
      }
      if (a < 0) {
         if (b > 0) {
            if (a + b < 0) {
               return a;
            } else if (a + b == 0) {
               return 0;
            } else {
               return b;
            }
         }
      }
      return 0;
   }
}
