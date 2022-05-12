//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1638 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            permute(nums, 0, list, result);
            return result;
        }

        private void permute(int[] nums, Integer index, List<Integer> list, List<List<Integer>> result) {
            if (index == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                Collections.swap(list, i, index);
                permute(nums, index + 1, list, result);
                Collections.swap(list, i, index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // ----------
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        permute(nums, new ArrayList<Integer>(), new HashSet<Integer>(), result);
//        return result;
//    }
//
//    private void permute(int[] nums, List<Integer> list, HashSet<Integer> set, List<List<Integer>> result) {
//        if (nums.length == list.size()) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (!set.contains(nums[i])) {
//                list.add(nums[i]);
//                set.add(nums[i]);
//                permute(nums, list, set, result);
//                list.remove(list.size() - 1);
//                set.remove(nums[i]);
//            }
//        }
//    }

}
