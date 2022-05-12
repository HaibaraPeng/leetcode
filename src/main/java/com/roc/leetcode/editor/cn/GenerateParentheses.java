//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
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
// Related Topics 字符串 动态规划 回溯 👍 2135 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(Arrays.toString(solution.generateParenthesis(3).toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> parenthesisList = new ArrayList<>();
            if (n == 0) return parenthesisList;
            generateParenthesis(parenthesisList, new StringBuilder(), n, n);
            return parenthesisList;
        }

        public void generateParenthesis(List<String> parenthesisList, StringBuilder parenthesis,
                                        int leftCount, int rightCount) {
            if (leftCount == 0 && rightCount == 1) {
                parenthesis.append(")");
                parenthesisList.add(parenthesis.toString());
                return;
            }
            if (leftCount == 0) {
                generateParenthesis(parenthesisList, parenthesis.append(")"), leftCount, --rightCount);
                return;
            }
            if (leftCount == rightCount) {
                generateParenthesis(parenthesisList, parenthesis.append("("), --leftCount, rightCount);
                return;
            }
            StringBuilder tempParenthesis = new StringBuilder(parenthesis);
            int tempLeftCount = leftCount;
            int tempRightCount = rightCount;
            generateParenthesis(parenthesisList, parenthesis.append("("), --leftCount, rightCount);
            parenthesis = tempParenthesis;
            leftCount = tempLeftCount;
            rightCount = tempRightCount;
            generateParenthesis(parenthesisList, parenthesis.append(")"), leftCount, --rightCount);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}