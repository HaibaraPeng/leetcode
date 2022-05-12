//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1525 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("(())"));
        int[] dp = new int[3];
        System.out.println(Arrays.toString(dp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int longestValidLength = 0;
            Deque<Integer> stack = new LinkedList<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        longestValidLength = Math.max(longestValidLength, i - stack.peek());
                    }
                }
            }
            return longestValidLength;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    // ------------栈----------------
//    public int longestValidParentheses(String s) {
//        int longestValidLength = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    longestValidLength = Math.max(longestValidLength, i - stack.peek());
//                }
//            }
//        }
//        return longestValidLength;
//    }

    // --------------不需要额外的空间----------------
//    public int longestValidParentheses(String s) {
//        int left = 0, right = 0, longestValidLength = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                left++;
//            } else {
//                right++;
//            }
//            if (left == right) {
//                longestValidLength = Math.max(longestValidLength, 2 * right);
//            } else if (right > left) {
//                left = right = 0;
//            }
//        }
//        // 上述会漏掉"(()()()"这种情况 因此需要逆序再次遍历
//        left = right = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == '(') {
//                left++;
//            } else {
//                right++;
//            }
//            if (left == right) {
//                longestValidLength = Math.max(longestValidLength, 2 * left);
//            } else if (right < left) {
//                left = right = 0;
//            }
//        }
//        return longestValidLength;
//    }

}
