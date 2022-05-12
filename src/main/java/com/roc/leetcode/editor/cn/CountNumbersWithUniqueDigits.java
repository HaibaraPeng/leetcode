//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。 
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：1
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 数学 动态规划 回溯 
// 👍 281 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
        solution.countNumbersWithUniqueDigits(8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            // 重复数字数组
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 10;
            n = Math.min(n, 10);
            for (int i = 2; i < n + 1; i++) {
                int temp = 9;
                for (int j = 0; j < i - 1; j++) {
                    temp = temp * (9 - j);
                }
                dp[i] = dp[i - 1] + temp;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}