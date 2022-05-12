//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] ： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 976 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4) return res;
            // 对nums排序
            Arrays.sort(nums);
            int size = nums.length;
            for (int one = 0; one < size - 3; one++) {
                if (one > 0 && nums[one] == nums[one - 1]) continue;
                for (int two = one + 1; two < size - 2; two++) {
                    if (two > one + 1 && nums[two] == nums[two - 1]) continue;
                    int tar = target - nums[one] - nums[two];
                    int four = size - 1;
                    for (int three = two + 1; three < size - 1; three++) {
                        if (three > two + 1 && nums[three] == nums[three - 1]) continue;
                        while (three < four && (nums[three] + nums[four]) > tar) {
                            four--;
                        }
                        if (three == four) break;
                        if (nums[three] + nums[four] == tar) {
                            List<Integer> array = new ArrayList<>();
                            array.add(nums[one]);
                            array.add(nums[two]);
                            array.add(nums[three]);
                            array.add(nums[four]);
                            res.add(array);
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
