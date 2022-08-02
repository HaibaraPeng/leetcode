//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 二分查找 👍 374 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        solution.judgeSquareSum(2147483600);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            int a = 0, b = (int) Math.sqrt(c);
            while (a <= b) {
                long cur = (long) a * a + (long) b * b;
                if (cur == c) {
                    return true;
                } else if (cur > c) {
                    b--;
                } else {
                    a++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}