//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 774 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        solution.removeInvalidParentheses("()())()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int len;

        public List<String> removeInvalidParentheses(String s) {
            char[] cs = s.toCharArray();
            int l = 0, r = 0;
            for (char c : cs) {
                if (c == '(') {
                    l++;
                } else if (c == ')') {
                    r++;
                }
            }
            int max = Math.min(l, r);
            Set<String> all = new HashSet<>();
            dfs(cs, 0, 0, max, "", all);
            List<String> ans = new ArrayList<>();
            for (String str : all) {
                if (str.length() == len) ans.add(str);
            }
            return ans;
        }

        void dfs(char[] cs, int u, int score, int max, String cur, Set<String> ans) {
            if (u == cs.length) {
                if (score == 0 && cur.length() >= len) {
                    len = Math.max(len, cur.length());
                    ans.add(cur);
                }
                return;
            }
            if (cs[u] == '(') {
                if (score + 1 <= max) dfs(cs, u + 1, score + 1, max, cur + "(", ans);
                dfs(cs, u + 1, score, max, cur, ans);
            } else if (cs[u] == ')') {
                if (score > 0) dfs(cs, u + 1, score - 1, max, cur + ")", ans);
                dfs(cs, u + 1, score, max, cur, ans);
            } else {
                dfs(cs, u + 1, score, max, cur + String.valueOf(cs[u]), ans);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}