package com.lilhui.leecode;

/**
 *
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 *
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 *
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 *
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 *
 * 输入：s = "tryhard", k = 4
 * 输出：1
 *
 * 提示：
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 *
 * @author littlehui
 * @date 2024/9/5 17:23
 * @version 1.0
 */
public class MaxVowels {

    public static int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += isVowel(s.charAt(i));
        }
        int max = count;
        //System.out.println("all:" + s);
        for (int i = 1; i < s.length() - k + 1; i++) {
            //System.out.println("pre:" + s.charAt(i-1));
            //System.out.println("next:" + s.charAt(i + k - 1));
            int preHasYuanyin = isVowel(s.charAt(i-1));
            int nextHasYuanyin = isVowel(s.charAt(i + k -1));
            count += nextHasYuanyin - preHasYuanyin;
            max = Math.max(max, count);
        }
        return max;
    }

    public static int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }


    public static void main(String[] args) {
        String str = "weallloveyou";
        System.out.println(maxVowels(str, 7));
    }
}
