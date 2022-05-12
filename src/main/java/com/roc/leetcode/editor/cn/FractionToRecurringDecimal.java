//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 347 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        solution.fractionToDecimal(1, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            long numeratorLong = numerator;
            long denominatorLong = denominator;
            if (numeratorLong % denominatorLong == 0) {
                return String.valueOf(numeratorLong / denominatorLong);
            }
            StringBuffer stringBuffer = new StringBuffer();
            // 处理符号部分
            if (numeratorLong < 0 ^ denominatorLong < 0) {
                stringBuffer.append('-');
            }
            // 处理整数部分
            numeratorLong = Math.abs(numeratorLong);
            denominatorLong = Math.abs(denominatorLong);
            stringBuffer.append(numeratorLong / denominatorLong);
            stringBuffer.append('.');
            // 处理小数部分
            StringBuffer fractionBuffer = new StringBuffer();
            Map<Long, Integer> map = new HashMap<>();
            long remain = numeratorLong % denominatorLong;
            int index = 0;
            while (remain != 0 && !map.containsKey(remain)) {
                map.put(remain, index);
                remain *= 10;
                fractionBuffer.append(remain / denominatorLong);
                remain = remain % denominatorLong;
                index++;
            }
            // 有循环
            if (remain != 0) {
                int circleIndex = map.get(remain);
                fractionBuffer.insert(circleIndex, '(');
                fractionBuffer.append(')');
            }
            stringBuffer.append(fractionBuffer);
            return stringBuffer.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
