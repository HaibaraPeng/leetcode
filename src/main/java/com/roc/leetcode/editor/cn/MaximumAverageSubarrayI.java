//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。 
//
// 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 
//
// 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 示例 2： 
//
// 
//输入：nums = [5], k = 1
//输出：5.00000
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= k <= n <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 滑动窗口 👍 261 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        solution.findMaxAverage(new int[]{-1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int n = nums.length;
            double average = Integer.MIN_VALUE;
            long sum = 0;
            for (int i = 0; i < k - 1; i++) {
                sum += nums[i];
            }
            for (int i = k - 1; i < n; i++) {
                sum += nums[i];
                average = Math.max(average, (double) sum / k);
                sum -= nums[i + 1 - k];
            }
            return average;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}