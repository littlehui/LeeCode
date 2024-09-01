package com.lilhui.leecode.old;

import javax.security.sasl.SaslServer;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;

/**
 * 幸运数字
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/14 22:12
 */
public class LuckNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            String luckStr = Integer.toString(a, c);
            int luckCount = 0;
            while (true) {
                int index = luckStr.indexOf(b+"");
                if (index > -1) {
                    luckCount ++;
                    luckStr = luckStr.substring(index + 1, luckStr.length());
                } else {
                    break;
                }
            }
            System.out.println(luckCount);
        }
    }
}
