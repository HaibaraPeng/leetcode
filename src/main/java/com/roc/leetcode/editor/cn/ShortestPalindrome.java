//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aacecaaa"
//输出："aaacecaaa"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出："dcbabcd"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 
// 👍 413 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class ShortestPalindrome {
    public static void main(String[] args) {
        Solution solution = new ShortestPalindrome().new Solution();
        solution.shortestPalindrome("abb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestPalindrome(String s) {
            int n = s.length();
            int[] fail = new int[n];
            Arrays.fill(fail, -1);
            for (int i = 1; i < n; ++i) {
                int j = fail[i - 1];
                while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                    j = fail[j];
                }
                if (s.charAt(j + 1) == s.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            int best = -1;
            for (int i = n - 1; i >= 0; --i) {
                while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                    best = fail[best];
                }
                if (s.charAt(best + 1) == s.charAt(i)) {
                    ++best;
                }
            }
            String add = (best == n - 1 ? "" : s.substring(best + 1));
            StringBuffer ans = new StringBuffer(add).reverse();
            ans.append(s);
            return ans.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
