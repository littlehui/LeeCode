package com.lilhui.leecode;

/**
 * TODO
 *
 * @author littlehui
 * @version 1.0
 * @date 2024/07/16 23:15
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int currentLongest = 0;
        int cursor = 0;
        char[] chars = s.toCharArray();
        int latestLongest = 0;
        if (s.equals("")) {
            return 0;
        }
        if (s.equals(" ") || s.trim().equals("")) {
            return 1;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            char currentChar = chars[i + 1];
            String tmpS = s.substring(cursor, i + 1);
            currentLongest = tmpS.length();
            latestLongest = Math.max(currentLongest, latestLongest);
            int indexOftmps = tmpS.indexOf(currentChar);
            if (indexOftmps > -1) {
                cursor += (indexOftmps + 1);
            } else {
                if ((i + 1)== (s.length() - 1)) {
                    if (currentLongest == latestLongest) {
                        latestLongest++;
                    }
                }
            }
        }
        return latestLongest;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
    }
}
