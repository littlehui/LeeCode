package com.lilhui.leecode;

/**
 *
 * 443.压缩字符串
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/22 22:39
 */
public class Compress {

   public int compress(char[] chars) {
      StringBuffer stringBuffer = new StringBuffer();
      int currentCharCount = 1;
      if (chars.length == 1) {
         return 1;
      }
      for (int i=0; i<chars.length - 1; i++) {
         currentCharCount = 1;
         for (int j=i+1; j<chars.length; j++) {
            if (chars[i] == chars[j]) {
               currentCharCount++;
               if (j == chars.length - 1) {
                  i = j;
                  stringBuffer.append(chars[i] + "");
                  if (currentCharCount > 1) {
                     stringBuffer.append(currentCharCount);
                  }
               }
            } else {
               stringBuffer.append(chars[i] + "");
               if (currentCharCount > 1) {
                  stringBuffer.append(currentCharCount);
               }
               if (j == chars.length - 1) {
                  stringBuffer.append(chars[j] + "");
                  i = j;
               } else {
                  i = j-1;
               }
               break;
            }
         }
      }
      char[] srcChars = stringBuffer.toString().toCharArray();
      for (int i = 0; i < srcChars.length; i++) {
         chars[i] = srcChars[i];
      }
      return stringBuffer.length();
   }

   public static void main(String[] args) {
      Compress compress = new Compress();
      char[] chars = new char[]{'a','b','c'};
      System.out.println(compress.compress(chars));
   }
}
