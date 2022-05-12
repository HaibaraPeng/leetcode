//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 672 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        int[][] array = new int[][]{
                {1},
                {0}
        };
        System.out.println(solution.uniquePathsWithObstacles(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) return 0;
            if (obstacleGrid[m - 1][n - 1] == 1) return 0;
            int[][] array = new int[m][n];
            for (int[] ints : array) {
                Arrays.fill(ints, -1);
            }
            return uniquePathsWithObstacles(0, 0, m, n, array, obstacleGrid);
        }

        private int uniquePathsWithObstacles(int row, int col, int m, int n, int[][] array, int[][] obstacleGrid) {
            if (array[row][col] != -1) return array[row][col];
            int count;
            if (row + 1 == m && col + 1 == n) {
                count = 1;
            } else if ((row + 1 == m || obstacleGrid[row + 1][col] == 1) &&
                    (col + 1 == n || obstacleGrid[row][col + 1] == 1)) {
                count = 0;
            } else if (row + 1 == m || obstacleGrid[row + 1][col] == 1) {
                count = uniquePathsWithObstacles(row, col + 1, m, n, array, obstacleGrid);
            } else if (col + 1 == n || obstacleGrid[row][col + 1] == 1) {
                count = uniquePathsWithObstacles(row + 1, col, m, n, array, obstacleGrid);
            } else {
                count = uniquePathsWithObstacles(row, col + 1, m, n, array, obstacleGrid)
                        + uniquePathsWithObstacles(row + 1, col, m, n, array, obstacleGrid);
            }
            array[row][col] = count;
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
