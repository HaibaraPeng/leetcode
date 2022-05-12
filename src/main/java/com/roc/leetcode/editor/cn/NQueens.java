//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 数组 回溯 👍 1094 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<Integer>> result = new ArrayList<>();
            List<List<String>> trueResult = new ArrayList<>();
            List<Integer> list = new ArrayList<>(n);
            solveNQueens(result, list, n);
            for (List<Integer> integers : result) {
                List<String> stringList = new ArrayList<>();
                for (Integer integer : integers) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        stringBuilder.append(i == integer ? "Q" : ".");
                    }
                    stringList.add(stringBuilder.toString());
                }
                trueResult.add(stringList);
            }
            return trueResult;
        }

        private void solveNQueens(List<List<Integer>> result, List<Integer> list, int n) {
            if (list.size() == n) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int j = 0; j < n; j++) {
                if (check(list, j)) {
                    list.add(j);
                    solveNQueens(result, list, n);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean check(List<Integer> list, int j) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == j || list.get(i) - list.size() + i == j || list.get(i) + list.size() - i == j)
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}