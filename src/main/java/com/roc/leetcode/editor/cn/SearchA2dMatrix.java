//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 704 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
//        int[][] matrix = new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
        int[][] matrix = new int[][]{
                {1},
                {3},
        };
        solution.searchMatrix(matrix, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int top = 0, down = m - 1, left = 0, right = n - 1, row = 0;
            while (top <= down) {
                int mid = top + (down - top) / 2;
                if (matrix[mid][0] == target) {
                    row = mid;
                    break;
                } else if (top == down && (mid == 0 || mid == m - 1)) {
                    row = mid;
                    break;
                } else if (matrix[mid][0] < target && matrix[mid + 1][0] > target) {
                    row = mid;
                    break;
                } else if (matrix[mid][0] < target) {
                    top = mid + 1;
                } else {
                    down = mid - 1;
                }
            }
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}