//给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序） 
//
// graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i（即不存在自环） 
// graph[i] 中的所有元素 互不相同 
// 保证输入为 有向无环图（DAG） 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 图 回溯 👍 340 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceToTarget().new Solution();
        int[][] graph = new int[][]{
                {1, 2},
                {3},
                {3},
                {},
        };
        solution.allPathsSourceTarget(graph);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            int n = graph.length;
            boolean[] arr = new boolean[n];
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            dfs(graph, res, list, arr, 0);
            return res;
        }

        private void dfs(int[][] graph, List<List<Integer>> res, List<Integer> list, boolean[] arr, int index) {
            if (arr[index]) {
                return;
            }
            if (index == graph.length - 1) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(index);
                res.add(temp);
                return;
            }
            int[] graphArr = graph[index];
            list.add(index);
            arr[index] = true;
            for (int i : graphArr) {
                dfs(graph, res, list, arr, i);
            }
            list.remove(list.size() - 1);
            arr[index] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}