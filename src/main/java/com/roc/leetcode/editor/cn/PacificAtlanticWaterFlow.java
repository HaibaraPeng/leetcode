//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 105 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 359 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
        int[][] heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] ty = {-1, 1, 0, 0};
        int[] tx = {0, 0, -1, 1};
        int m;
        int n;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            m = heights.length;
            n = heights[0].length;
            boolean[][] reach1 = new boolean[m][n]; // 太平洋
            boolean[][] reach2 = new boolean[m][n]; // 大西洋
            boolean[][] visited1 = new boolean[m][n]; // 太平洋
            boolean[][] visited2 = new boolean[m][n]; // 大西洋

            for (int i = 0; i < m; i++) {
                reach1[i][0] = true;
                reach2[i][n - 1] = true;
                DFS(i, 0, heights, reach1, visited1);
                DFS(i, n - 1, heights, reach2, visited2);
            }
            for (int i = 0; i < n; i++) {
                reach1[0][i] = true;
                reach2[m - 1][i] = true;
                DFS(0, i, heights, reach1, visited1);
                DFS(m - 1, i, heights, reach2, visited2);
            }
            List<List<Integer>> lists = new ArrayList<>(); // 存放结果
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (reach1[i][j] && reach2[i][j]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        lists.add(list);
                    }
                }
            }
            return lists;
        }

        public void DFS(int i, int j, int[][] heights, boolean[][] reach, boolean[][] visited) {
            if (visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int y = i + ty[k];
                int x = j + tx[k];
                if (y >= 0 && y < m && x >= 0 && x < n && !visited[y][x] && heights[i][j] <= heights[y][x]) {
                    reach[y][x] = true;
                    DFS(y, x, heights, reach, visited);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}