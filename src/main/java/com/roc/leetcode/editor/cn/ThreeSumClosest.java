//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 903 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
        solution.threeSumClosest(nums, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) return 0;
            int threeSumClosestNum = 100000;
            int size = nums.length;
            // 对nums进行排序
            Arrays.sort(nums);
            for (int one = 0; one < size - 2; one++) {
                if (one > 0 && nums[one] == nums[one - 1]) {
                    continue;
                }
                // 使用双指针
                int two = one + 1, three = size - 1;
                while (two < three) {
                    int sum = nums[one] + nums[two] + nums[three];
                    // 如果sum等于target直接返回
                    if (sum == target) return sum;
                    // 根据差值的绝对值来更新答案
                    if (Math.abs(sum - target) < Math.abs(threeSumClosestNum - target)) {
                        threeSumClosestNum = sum;
                    }
                    if (sum > target) {
                        // 如果和大于 target，移动 three 对应的指针
                        int three0 = three - 1;
                        // 移动到下一个不相等的元素
                        while (two < three0 && nums[three0] == nums[three]) {
                            three0--;
                        }
                        three = three0;
                    } else {
                        // 如果和大于 target，移动 c 对应的指针
                        int two0 = two + 1;
                        // 移动到下一个不相等的元素
                        while (two0 < three && nums[two0] == nums[two]) {
                            two0++;
                        }
                        two = two0;
                    }
                }
            }
            return threeSumClosestNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
