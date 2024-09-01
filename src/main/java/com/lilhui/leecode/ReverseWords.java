package com.lilhui.leecode;

import java.util.Locale;

/**
 *
 * 151. 反转字符串中的单词
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/23 22:05
 */
public class ReverseWords {

   public String reverseWords(String s) {
      String str = s.trim();
      StringBuffer stringBuffer = new StringBuffer();
      String[] strArray = str.split(" ");
      for (int i=0; i < strArray.length; i++) {
         if (i > 0) {
            if (!stringBuffer.toString().endsWith(" ")) {
               stringBuffer.append(" ");
            }
         }
         stringBuffer.append(strArray[strArray.length - 1 - i]);
      }
      return stringBuffer.toString();
   }
}
