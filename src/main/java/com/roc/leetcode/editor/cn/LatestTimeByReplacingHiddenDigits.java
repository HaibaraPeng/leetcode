//给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。 
//
// 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。 
//
// 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。 
//
// 
//
// 示例 1： 
//
// 
//输入：time = "2?:?0"
//输出："23:50"
//解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
// 
//
// 示例 2： 
//
// 
//输入：time = "0?:3?"
//输出："09:39"
// 
//
// 示例 3： 
//
// 
//输入：time = "1?:22"
//输出："19:22"
// 
//
// 
//
// 提示： 
//
// 
// time 的格式为 hh:mm 
// 题目数据保证你可以由输入的字符串生成有效的时间 
// 
// Related Topics 字符串 👍 62 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        Solution solution = new LatestTimeByReplacingHiddenDigits().new Solution();
        solution.maximumTime("?4:03");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumTime(String time) {
            StringBuilder sb = new StringBuilder();
            // 处理小时
            if (time.charAt(0) == '?') {
                if (time.charAt(1) == '?' || time.charAt(1) < '4') {
                    sb.append(2);
                } else {
                    sb.append(1);
                }
            } else {
                sb.append(time.charAt(0));
            }
            if (time.charAt(1) == '?') {
                if (sb.charAt(0) != '2') {
                    sb.append(9);
                } else {
                    sb.append(3);
                }
            } else {
                sb.append(time.charAt(1));
            }
            sb.append(':');
            // 处理分钟
            if (time.charAt(3) == '?') {
                sb.append(5);
            } else {
                sb.append(time.charAt(3));
            }
            if (time.charAt(4) == '?') {
                sb.append(9);
            } else {
                sb.append(time.charAt(4));
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}