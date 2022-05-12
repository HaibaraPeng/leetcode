//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 
// 👍 3997 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Status {
            int lSum, rSum, mSum, iSum;

            public Status(int lSum, int rSum, int mSum, int iSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.mSum = mSum;
                this.iSum = iSum;
            }
        }

        public int maxSubArray(int[] nums) {
            return getInfo(nums, 0, nums.length - 1).mSum;
        }

        public Status getInfo(int[] nums, int left, int right) {
            if (left == right) return new Status(nums[left], nums[left], nums[left], nums[left]);
            int mid = left + ((right - left) >> 1);
            Status lStatus = getInfo(nums, left, mid);
            Status rStatus = getInfo(nums, mid + 1, right);
            return pushUp(lStatus, rStatus);
        }

        private Status pushUp(Status lStatus, Status rStatus) {
            int iSum = lStatus.iSum + rStatus.iSum;
            int lSum = Math.max(lStatus.lSum, lStatus.iSum + rStatus.lSum);
            int rSum = Math.max(rStatus.rSum, lStatus.rSum + rStatus.iSum);
            int mSum = Math.max(Math.max(lStatus.mSum, rStatus.mSum), lStatus.rSum + rStatus.lSum);
            return new Status(lSum, rSum, mSum, iSum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // -------动态规划---------
//    public int maxSubArray(int[] nums) {
//        int pre = 0, max = nums[0];
//        for (int num : nums) {
//            pre = Math.max(num, pre + num);
//            max = Math.max(max, pre);
//        }
//        return max;
//    }

}
