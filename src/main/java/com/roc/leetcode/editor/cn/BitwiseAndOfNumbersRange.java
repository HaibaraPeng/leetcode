//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 351 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange().new Solution();
        System.out.println(solution.rangeBitwiseAnd(1, 214));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            String binaryLeft = Integer.toBinaryString(left);
            String binaryRight = Integer.toBinaryString(right);
            if (binaryLeft.length() < binaryRight.length()) return 0;
            StringBuilder stringBuilder = new StringBuilder();
            boolean flag = false;
            for (int i = 0; i < binaryLeft.length(); i++) {
                if (flag) {
                    stringBuilder.append('0');
                } else {
                    if (binaryLeft.charAt(i) == binaryRight.charAt(i)) {
                        stringBuilder.append(binaryLeft.charAt(i));
                    } else {
                        stringBuilder.append('0');
                        flag = true;
                    }
                }
            }
            return Integer.valueOf(stringBuilder.toString(), 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
