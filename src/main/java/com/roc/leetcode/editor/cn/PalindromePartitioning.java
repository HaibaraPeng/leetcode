//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 930 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] dp;
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], true);
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }

            dfs(s, 0);
            return res;
        }

        public void dfs(String s, int len) {
            if (len == n) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = len; i < n; i++) {
                if (dp[len][i]) {
                    list.add(s.substring(len, i + 1));
                    dfs(s, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
