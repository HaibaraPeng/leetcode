//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 105 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 
// 👍 729 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        solution.removeKdigits("1432219", 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            int len = num.length();
            if (len <= k) return "0";
            char[] arr = num.toCharArray();
            char[] res = new char[len];
            int top = -1;
            int n = len - k;
            for (char c : arr) {
                while (k > 0 && top != -1 && res[top] > c) {
                    top--;
                    k--;
                }
                res[++top] = c;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (sb.length() == 0 && res[i] == '0') continue;
                sb.append(res[i]);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
