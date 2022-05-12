//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3850 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) return res;
            int size = nums.length;
            // nums排序
            Arrays.sort(nums);
            for (int i = 0; i < size - 2; i++) {
                // 需要和上一次枚举的数不相同
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int num3Index = size - 1;
                int target = -nums[i];
                for (int j = i + 1; j < size - 1; j++) {// 需要和上一次枚举的数不相同
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    while (j < num3Index && (nums[j] + nums[num3Index]) > target) {
                        num3Index--;
                    }
                    if (j == num3Index) break;
                    if (nums[j] + nums[num3Index] == target) {
                        List<Integer> array = new ArrayList<>();
                        array.add(nums[i]);
                        array.add(nums[j]);
                        array.add(nums[num3Index]);
                        res.add(array);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
