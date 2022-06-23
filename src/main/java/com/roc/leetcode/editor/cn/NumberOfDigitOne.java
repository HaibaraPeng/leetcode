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
// 0 <= n <= 10⁹ 
// 
// Related Topics 递归 数学 动态规划 👍 431 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        solution.countDigitOne(12345);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            String s = String.valueOf(n);
            int m = s.length();
            if (m == 1) {
                return n > 0 ? 1 : 0;
            }
            // 计算第 i 位前缀代表的数值，和后缀代表的数值
            // 例如 abcde 则有 ps[2] = ab; ss[2] = de
            int[] ps = new int[m], ss = new int[m];
            ss[0] = Integer.parseInt(s.substring(1));
            for (int i = 1; i < m - 1; i++) {
                ps[i] = Integer.parseInt(s.substring(0, i));
                ss[i] = Integer.parseInt(s.substring(i + 1));
            }
            ps[m - 1] = Integer.parseInt(s.substring(0, m - 1));
            // 分情况讨论
            int ans = 0;
            for (int i = 0; i < m; i++) {
                // x 为当前位数值，len 为当前位后面长度为多少
                int x = s.charAt(i) - '0', len = m - i - 1;
                int prefix = ps[i], suffix = ss[i];
                int tot = 0;
                tot += prefix * Math.pow(10, len);
                if (x == 0) {
                } else if (x == 1) {
                    tot += suffix + 1;
                } else {
                    tot += Math.pow(10, len);
                }
                ans += tot;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}