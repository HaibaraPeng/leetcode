//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 514 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        System.out.println(solution.minCut("aaabaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minCut(String s) {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (i + 1 == j) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                    }
                }
            }

            int[] resDp = new int[len];
            Arrays.fill(resDp, Integer.MAX_VALUE);
            for (int i = 0; i < len; i++) {
                if (dp[0][i]) {
                    resDp[i] = 0;
                } else {
                    // 从左边开始获取?,i最大回文
                    for (int j = 0; j < i; j++) {
                        if (dp[j + 1][i]) {
                            resDp[i] = Math.min(resDp[i], resDp[j] + 1);
                        }
                    }
                }
            }
            return resDp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
