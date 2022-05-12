//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 562 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        System.out.println(solution.addStrings("9999999999999", "9999999999"));
        System.out.println(9999999999999L + 9999999999L);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length(), len2 = num2.length(), index1 = len1 - 1, index2 = len2 - 1, flag = 0;
            StringBuilder sb = new StringBuilder();
            while (index1 >= 0 || index2 >= 0) {
                if (index1 >= 0 && index2 >= 0) {
                    int value = flag + (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0');
                    if (value >= 10) {
                        flag = 1;
                        value = value % 10;
                    } else {
                        flag = 0;
                    }
                    sb.append(value);
                    index1--;
                    index2--;
                } else if (index1 >= 0) {
                    int value = flag + (num1.charAt(index1) - '0');
                    if (value >= 10) {
                        flag = 1;
                        value = value % 10;
                    } else {
                        flag = 0;
                    }
                    sb.append(value);
                    index1--;
                } else {
                    int value = flag + (num2.charAt(index2) - '0');
                    if (value >= 10) {
                        flag = 1;
                        value = value % 10;
                    } else {
                        flag = 0;
                    }
                    sb.append(value);
                    index2--;
                }
            }
            if (flag > 0) sb.append(flag);
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}