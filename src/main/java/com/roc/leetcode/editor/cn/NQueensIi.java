//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// Related Topics 回溯 👍 315 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        System.out.println(solution.totalNQueens(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int result = 0;

        public int totalNQueens(int n) {
            List<Integer> list = new ArrayList<>(n);
            solveNQueens(list, n);
            return result;
        }

        private void solveNQueens(List<Integer> list, int n) {
            if (list.size() == n) {
                result++;
                return;
            }
            for (int j = 0; j < n; j++) {
                if (check(list, j)) {
                    list.add(j);
                    solveNQueens(list, n);
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