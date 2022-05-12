//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
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
// Related Topics 数组 矩阵 模拟 
// 👍 529 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] ints = solution.generateMatrix(4);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            generateMatrix(1, 0, n - 1, result);
            return result;
        }

        private void generateMatrix(int index, int left, int right, int[][] result) {
            if (left == right) {
                result[left][right] = index;
                return;
            }
            if (left > right) return;
            for (int i = left; i < right; i++) {
                result[left][i] = index++;
            }
            for (int i = left; i < right; i++) {
                result[i][right] = index++;
            }
            for (int i = right; i > left; i--) {
                result[right][i] = index++;
            }
            for (int i = right; i > left; i--) {
                result[i][left] = index++;
            }
            generateMatrix(index, left + 1, right - 1, result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
