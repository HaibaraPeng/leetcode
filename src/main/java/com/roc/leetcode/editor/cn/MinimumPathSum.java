//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1069 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        int[][] array = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] array = new int[m][n];
            return minPathSum(0, 0, m, n, array, grid);
        }

        private int minPathSum(int row, int col, int m, int n, int[][] array, int[][] grid) {
            if (array[row][col] != 0) return array[row][col];
            int min;
            if (row + 1 == m && col + 1 == n) {
                min = grid[row][col];
            } else if (row + 1 == m) {
                min = grid[row][col] + minPathSum(row, col + 1, m, n, array, grid);
            } else if (col + 1 == n) {
                min = grid[row][col] + minPathSum(row + 1, col, m, n, array, grid);
            } else {
                min = grid[row][col] + Math.min(minPathSum(row, col + 1, m, n, array, grid),
                        minPathSum(row + 1, col, m, n, array, grid));
            }
            array[row][col] = min;
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
