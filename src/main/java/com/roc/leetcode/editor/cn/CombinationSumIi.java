//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
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
//输入: candidates = [2,5,2,1,2], target = 5,
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
// Related Topics 数组 回溯 👍 1120 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int candidate : candidates) {
                map.put(candidate, map.getOrDefault(candidate, 0) + 1);
            }
            List<Integer> arr = new ArrayList<>(map.keySet());
            Collections.sort(arr);
            Set<List<Integer>> res = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            combinationSum2(map, arr, target, res, list, 0);
            return new ArrayList<>(res);
        }

        private void combinationSum2(Map<Integer, Integer> map, List<Integer> arr, int target, Set<List<Integer>> res, List<Integer> list, int i) {
            if (target == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(list);
                res.add(temp);
                return;
            }
            for (int j = i; j < arr.size(); j++) {
                int value = arr.get(j);
                if (map.get(value) == 0) {
                    continue;
                }
                target -= value;
                if (target < 0) {
                    return;
                }
                list.add(value);
                map.put(value, map.get(value) - 1);
                combinationSum2(map, arr, target, res, list, j);
                list.remove(list.size() - 1);
                target += value;
                map.put(value, map.get(value) + 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}