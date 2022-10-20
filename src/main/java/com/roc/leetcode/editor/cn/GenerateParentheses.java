//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2916 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            dfs(res, sb, n, n);
            return res;
        }

        private void dfs(List<String> res, StringBuilder sb, int left, int right) {
            if (left == 0 && right == 0) {
                res.add(sb.toString());
                return;
            }
            if (left == 0) {
                sb.append(")");
                right--;
                dfs(res, sb, left, right);
                sb.deleteCharAt(sb.length() - 1);
                right++;
            } else if (left == right) {
                sb.append("(");
                left--;
                dfs(res, sb, left, right);
                sb.deleteCharAt(sb.length() - 1);
                left++;
            } else {
                sb.append("(");
                left--;
                dfs(res, sb, left, right);
                sb.deleteCharAt(sb.length() - 1);
                left++;
                sb.append(")");
                right--;
                dfs(res, sb, left, right);
                sb.deleteCharAt(sb.length() - 1);
                right++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}