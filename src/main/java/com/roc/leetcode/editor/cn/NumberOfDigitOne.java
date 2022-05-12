//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 384 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        solution.countDigitOne(109);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
//            int[] dp = new int[n + 1];
//            dp[0] = 0;
//            for (int i = 1; i < n + 1; i++) {
//                int num = i;
//                int count = 0;
//                if (num % 10 == 1) count++;
//                num /= 10;
//                if (num > 0) count = count + dp[num] - dp[num - 1];
//                dp[i] = dp[i - 1] + count;
//            }
//            return dp[n];

            // mulk 表示 10^k
            // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
            // 但为了让代码看起来更加直观，这里保留了 k
            long mulk = 1;
            int ans = 0;
            for (int k = 0; n >= mulk; ++k) {
                ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
                mulk *= 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
