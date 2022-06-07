//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5297 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            Integer len = 0;
            for (int i = 0; i < s.length(); i++) {
                // 奇数回文
                String odd = getString(s, i, i);
                if (odd.length() > len) {
                    res = odd;
                    len = odd.length();
                }
                // 偶数回文
                if (i < s.length() - 1) {
                    String even = getString(s, i, i + 1);
                    if (even.length() > len) {
                        res = even;
                        len = even.length();
                    }
                }
            }
            return res;
        }

        private String getString(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}