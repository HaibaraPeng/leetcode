//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 
// 👍 498 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new DifferentWaysToAddParentheses().new Solution();
        solution.diffWaysToCompute("2*3-4*5");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> res = new ArrayList<>();
            List<Integer> numList = new ArrayList<>();
            List<Character> operationList = new ArrayList<>();
            int len = expression.length();
            // 初始化数据组和运算符组
            int num = 0;
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                } else {
                    numList.add(num);
                    num = 0;
                    operationList.add(expression.charAt(i));
                }
            }
            numList.add(num);
            Map<String, List<Integer>> resMap = new HashMap<>();
            int numSize = numList.size();
            // map 初始化
            for (int i = 0; i < numSize; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(numList.get(i));
                String key = i + String.valueOf(i);
                resMap.put(key, list);
            }
            // 两个数字到N个数字
            for (int i = 2; i < numSize + 1; i++) {
                // 开始下标
                for (int left = 0; left < numSize; left++) {
                    // 结束下标
                    int right = left + i - 1;
                    if (right >= numSize) break;
                    List<Integer> list = new ArrayList<>();
                    // 分为left ~ s,s+1 ~ right两部分
                    for (int s = left; s < right; s++) {
                        List<Integer> list1 = resMap.get(left + String.valueOf(s));
                        List<Integer> list2 = resMap.get((s + 1) + String.valueOf(right));
                        for (int x = 0; x < list1.size(); x++) {
                            for (int y = 0; y < list2.size(); y++) {
                                // 第 s 个数字下标对应是第 s 个运算符
                                char op = operationList.get(s);
                                list.add(calculate(list1.get(x), list2.get(y), op));
                            }
                        }
                    }
                    resMap.put(left + String.valueOf(right), list);
                }
            }
            return resMap.get("0" + (numSize - 1));
        }

        public boolean isOperation(char c) {
            return c == '+' || c == '-' || c == '*';
        }

        public int calculate(int num1, int num2, char operation) {
            if (operation == '+') {
                return num1 + num2;
            } else if (operation == '-') {
                return num1 - num2;
            } else {
                return num1 * num2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
