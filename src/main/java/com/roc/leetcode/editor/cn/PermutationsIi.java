//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 867 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            boolean[] choose = new boolean[nums.length];
            Arrays.sort(nums);
            permuteUnique(nums, list, result, choose, 0);
            return result;
        }

        private void permuteUnique(int[] nums, List<Integer> list, List<List<Integer>> result, boolean[] choose, int i) {
            if (i == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int j = 0; j < nums.length; j++) {
                if (choose[j] || (j > 0 && nums[j - 1] == nums[j]) && choose[j - 1]) continue;
                list.add(nums[j]);
                choose[j] = true;
                permuteUnique(nums, list, result, choose, i + 1);
                list.remove(i);
                choose[j] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
