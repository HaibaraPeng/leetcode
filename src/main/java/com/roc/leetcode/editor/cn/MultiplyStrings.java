//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 760 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("999", "999"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            int len1 = num1.length();
            int len2 = num2.length();
            int[] temp = new int[len1 + len2];
            // 做乘法过程计算
            for (int i = len1 - 1; i >= 0; i--) {
                int intNum1 = num1.charAt(i) - '0';
                for (int j = len2 - 1; j >= 0; j--) {
                    int intNum2 = num2.charAt(j) - '0';
                    temp[i + j + 1] += intNum1 * intNum2;
                }
            }
            // 逢十进一
            for (int i = temp.length - 1; i > 0; i--) {
                temp[i - 1] += temp[i] / 10;
                temp[i] = temp[i] % 10;
            }
            // 拼接字符串
            StringBuilder result = new StringBuilder();
            if (temp[0] > 0) result.append(temp[0]);
            for (int i = 1; i < temp.length; i++) {
                result.append(temp[i]);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
