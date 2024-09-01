package com.lilhui.leecode.linklist;

import java.util.Stack;

/**
 * TODO
 * 小行星碰撞
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
