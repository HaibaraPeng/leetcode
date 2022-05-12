//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1621 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] a = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = solution.combinationSum(a, 7);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> combine = new ArrayList<Integer>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            // 直接跳过
            dfs(candidates, target, ans, combine, idx + 1);
            // 选择当前数
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    // ------------自己解答-----------
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(candidates);
//        if (candidates == null || candidates.length == 0 || candidates[0] > target) return result;
//        combinationSum(result, new ArrayList<Integer>(), candidates, target, 0);
//        return result;
//    }
//
//    public void combinationSum(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int index) {
//        if (target == 0) {
//            List<Integer> newTemp = temp.stream().sorted().collect(Collectors.toList());
//            if (!contains(result, newTemp)) {
//                result.add(newTemp);
//            }
//            return;
//        }
//        if (candidates[0] > target) return;
//        for (int candidate : candidates) {
//            temp.add(candidate);
//            combinationSum(result, temp, candidates, target - candidate, index + 1);
//            temp.remove(index);
//        }
//    }
//
//    public boolean contains(List<List<Integer>> result, List<Integer> temp) {
//        if (result.size() == 0) return false;
//        int tempLen = temp.size();
//        long count = result.stream()
//                .filter(list -> list.size() == tempLen && Arrays.deepEquals(list.toArray(), temp.toArray()))
//                .count();
//        return count > 0;
//    }

}
