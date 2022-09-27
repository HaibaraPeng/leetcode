//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 937 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        solution.subsetsWithDup(new int[]{1, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(8);
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<Integer> arr = new ArrayList<>(map.keySet());
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            subsetsWithDup(res, map, arr, list, 0);
            return res;
        }

        private void subsetsWithDup(List<List<Integer>> res, Map<Integer, Integer> map, List<Integer> arr, List<Integer> list, int index) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            for (int i = index; i < arr.size(); i++) {
                Integer value = arr.get(i);
                if (map.get(value) > 0) {
                    list.add(value);
                    map.put(value, map.get(value) - 1);
                    subsetsWithDup(res, map, arr, list, i);
                    list.remove(list.size() - 1);
                    map.put(value, map.get(value) + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}