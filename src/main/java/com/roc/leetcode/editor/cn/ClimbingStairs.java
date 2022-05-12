//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2040 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(44));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (n == 2) return 2;
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            return climbStairs(n - 1, dp);
        }

        private int climbStairs(int i, int[] dp) {
            if (i == 0 || i == 1 || dp[i] != 0) return dp[i];
            int dp2 = climbStairs(i - 2, dp);
            int dp1 = climbStairs(i - 1, dp);
            dp[i] = dp2 + dp1;
            return dp[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
