//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 913 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        solution.spiralOrder(new int[][]{
                {1}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    order.add(matrix[top][column]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        order.add(matrix[bottom][column]);
                    }
                    for (int row = bottom; row > top; row--) {
                        order.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    // 递归
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> result = new ArrayList<>();
//        int row = matrix.length;
//        int col = matrix[0].length;
//        spiralOrder(matrix, 0, 0, row - 1, col - 1, result);
//        System.out.println(Arrays.toString(result.toArray()));
//        return result;
//    }
//
//    public void spiralOrder(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol, List<Integer> result) {
//        if (leftRow == rightRow) {
//            for (int i = leftCol; i <= rightCol; i++) {
//                result.add(matrix[leftRow][i]);
//            }
//            return;
//        }
//        if (leftCol == rightCol) {
//            for (int i = leftRow; i <= rightRow; i++) {
//                result.add(matrix[i][leftCol]);
//            }
//            return;
//        }
//        if (leftRow < rightRow && leftCol < rightCol) {
//            for (int i = leftCol; i < rightCol; i++) {
//                result.add(matrix[leftRow][i]);
//            }
//            for (int i = leftRow; i < rightRow; i++) {
//                result.add(matrix[i][rightCol]);
//            }
//            for (int i = rightCol; i > leftCol; i--) {
//                result.add(matrix[rightRow][i]);
//            }
//            for (int i = rightRow; i > leftRow; i--) {
//                result.add(matrix[i][leftCol]);
//            }
//        }
//        spiralOrder(matrix, leftRow + 1, leftCol + 1, rightRow - 1, rightCol - 1, result);
//    }

}
