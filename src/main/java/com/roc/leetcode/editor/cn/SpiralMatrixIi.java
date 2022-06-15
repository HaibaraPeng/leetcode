//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 733 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            generateMatrix(res, 0, 0, n - 1, n - 1, 1);
            return res;
        }

        private void generateMatrix(int[][] res, int x1, int y1, int x2, int y2, int start) {
            if (x1 > x2) {
                return;
            }
            if (x1 == x2) {
                res[x1][y1] = start;
                return;
            }
            for (int i = y1; i < y2; i++) {
                res[x1][i] = start++;
            }
            for (int i = x1; i < x2; i++) {
                res[i][y2] = start++;
            }
            for (int i = y2; i > y1; i--) {
                res[x2][i] = start++;
            }
            for (int i = x2; i > x1; i--) {
                res[i][y1] = start++;
            }
            generateMatrix(res, x1 + 1, y1 + 1, x2 - 1, y2 - 1, start);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}