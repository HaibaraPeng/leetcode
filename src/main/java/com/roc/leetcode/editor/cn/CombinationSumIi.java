//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 731 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] can = new int[]{10, 1, 2, 7, 6, 1, 5};
        solution.combinationSum2(can, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<int[]> freq = new ArrayList<int[]>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> sequence = new ArrayList<Integer>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            for (int num : candidates) {
                int size = freq.size();
                if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                    freq.add(new int[]{num, 1});
                } else {
                    ++freq.get(size - 1)[1];
                }
            }
            dfs(0, target);
            return ans;
        }

        public void dfs(int pos, int rest) {
            if (rest == 0) {
                ans.add(new ArrayList<Integer>(sequence));
                return;
            }
            if (pos == freq.size() || rest < freq.get(pos)[0]) {
                return;
            }
            dfs(pos + 1, rest);
            int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
            for (int i = 1; i <= most; ++i) {
                sequence.add(freq.get(pos)[0]);
                dfs(pos + 1, rest - i * freq.get(pos)[0]);
            }
            for (int i = 1; i <= most; ++i) {
                sequence.remove(sequence.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}