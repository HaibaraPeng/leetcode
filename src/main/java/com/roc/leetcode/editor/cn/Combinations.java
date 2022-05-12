//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 784 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(4, 4);
        for (List<Integer> integers : combine) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            choose(result, new ArrayList<Integer>(), n, k, 1, 1);
            return result;
        }

        private void choose(List<List<Integer>> result, ArrayList<Integer> list, int n, int k, int nIndex, int kIndex) {
            if (kIndex - 1 == k) {
                result.add(new ArrayList<>(list));
                return;
            }
            int remain = k - kIndex;
            for (int i = nIndex; i < n + 1 - remain; i++) {
                list.add(i);
                choose(result, list, n, k, i + 1, kIndex + 1);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
