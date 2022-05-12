//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
//
// 注意: 
//
// 
// 十六进制中所有字母(a-f)都必须是小写。 
// 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
// 给定的数确保在32位有符号整数范围内。 
// 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。 
// 
//
// 示例 1： 
//
// 
//输入:
//26
//
//输出:
//"1a"
// 
//
// 示例 2： 
//
// 
//输入:
//-1
//
//输出:
//"ffffffff"
// 
// Related Topics 位运算 数学 👍 243 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
        System.out.println(solution.toHex(-1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHex(int num) {
            String binary = Integer.toBinaryString(num);
            StringBuilder sb = new StringBuilder();
            for (int i = binary.length(); i > 0; i -= 4) {
                if (i < 4) {
                    sb.append(convertToHex(binary.substring(0, i)));
                } else {
                    sb.append(convertToHex(binary.substring(i - 4, i)));
                }
            }
            return sb.reverse().toString();
        }

        private String convertToHex(String binary) {
            Integer integer = Integer.valueOf(binary, 2);
            if (integer == 10) {
                return "a";
            } else if (integer == 11) {
                return "b";
            } else if (integer == 12) {
                return "c";
            } else if (integer == 13) {
                return "d";
            } else if (integer == 14) {
                return "e";
            } else if (integer == 15) {
                return "f";
            } else {
                return String.valueOf(integer);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}