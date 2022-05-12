//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
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
// 1 <= n, m <= 300 
// -109 <= matrix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 914 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        solution.searchMatrix(matrix, 14);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int x = 0, y = n - 1;
            while (x < m && y >= 0) {
                if (matrix[x][y] == target) {
                    return true;
                }
                if (matrix[x][y] > target) {
                    --y;
                } else {
                    ++x;
                }
            }
            return false;
        }


//        private boolean res;

//        public boolean searchMatrix(int[][] matrix, int target) {
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int left = 0, right = n - 1;
//            for (int i = 0; i < m; i++) {
//                if (res) return true;
//                right = binarySearch(matrix[i], target, left, right);
//            }
//            return res;
//        }
//
//        public int binarySearch(int[] arr, int target, int left, int right) {
//            int mid = 0;
//            while (left <= right) {
//                mid = left + (right - left) / 2;
//                if (arr[mid] == target) {
//                    res = true;
//                    return mid;
//                }
//                if (arr[mid] > target) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            return mid;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
