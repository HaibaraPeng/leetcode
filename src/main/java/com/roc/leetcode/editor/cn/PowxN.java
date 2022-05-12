//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x⁴
//
// Related Topics 递归 数学 👍 787 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        System.out.println(solution.myPow(2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        private double quickMul(double x, long n) {
            if (n == 0) return 1.0;
            double y = quickMul(x, n / 2);
            return n % 2 == 0 ? y * y : y * y * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}