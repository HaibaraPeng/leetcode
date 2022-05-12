//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 681 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            // 将边缘o及相关联的o变为k
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') render(board, m, n, i, 0);
                if (board[i][n - 1] == 'O') render(board, m, n, i, n - 1);
            }
            for (int j = 1; j < n - 1; j++) {
                if (board[0][j] == 'O') render(board, m, n, 0, j);
                if (board[m - 1][j] == 'O') render(board, m, n, m - 1, j);
            }
            // 将剩下的O变为X 将K变为O
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'K') board[i][j] = 'O';
                }
            }
        }

        private void render(char[][] board, int m, int n, int row, int col) {
            board[row][col] = 'K';
            if (row > 0 && board[row - 1][col] == 'O') render(board, m, n, row - 1, col);
            if (row < m - 1 && board[row + 1][col] == 'O') render(board, m, n, row + 1, col);
            if (col > 0 && board[row][col - 1] == 'O') render(board, m, n, row, col - 1);
            if (col < n - 1 && board[row][col + 1] == 'O') render(board, m, n, row, col + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
