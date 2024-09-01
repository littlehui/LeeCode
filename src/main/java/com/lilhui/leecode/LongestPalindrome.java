package com.lilhui.leecode;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/17 00:12
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String lonestPalding = "";
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
        }
        for (int i=0; i < s.length() - 1; i++) {
            for (int j = i; j<s.length(); j++) {
                String tmpS = s.substring(i, j+1);
                if (tmpS.length()%2 == 0) {
                    //长度偶数
                    String leftStr = tmpS.substring(0, tmpS.length()/2);
                    String rightStr = tmpS.substring(tmpS.length()/2);
                    boolean validFlag = true;
                    for (int l=0;l<leftStr.length();l++) {
                        if (leftStr.charAt(l) != rightStr.charAt(rightStr.length() - 1 -l)) {
                            validFlag = false;
                        }
                    }
                    if (validFlag) {
                        lonestPalding = lonestPalding.length() > tmpS.length() ? lonestPalding : tmpS;
                    }
                } else {
                    //长度奇数
                    String leftStr = tmpS.substring(0, tmpS.length()/2);
                    String rightStr = tmpS.substring(tmpS.length()/2+1);
                    boolean validFlag = true;
                    for (int l=0;l<leftStr.length();l++) {
                        if (leftStr.charAt(l) != rightStr.charAt(rightStr.length()- 1 - l)) {
                            validFlag = false;
                        }
                    }
                    if (validFlag) {
                        lonestPalding = lonestPalding.length() > tmpS.length() ? lonestPalding : tmpS;
                    }
                }
            }
        }
        return lonestPalding;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abb"));
    }
}
