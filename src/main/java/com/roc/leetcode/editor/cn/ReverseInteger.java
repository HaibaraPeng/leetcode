//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3074 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int i = -2147483648;
        System.out.println(solution.reverse(i));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            if (x == 0) {
                return 0;
            } else {
                int reverse = 0;
                while (x != 0) {
                    int module = x % 10;
                    //判断是否 大于 最大32位整数
                    if (reverse > 214748364 || (reverse == 214748364 && module > 7)) {
                        return 0;
                    }
                    //判断是否 小于 最小32位整数
                    if (reverse < -214748364 || (reverse == -214748364 && module < -8)) {
                        return 0;
                    }
                    reverse = reverse * 10 + module;
                    x = x / 10;
                }
                return reverse;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
