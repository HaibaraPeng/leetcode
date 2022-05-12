//峰值元素是指其值严格大于左右相邻值的元素。 
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
// Related Topics 数组 二分查找 
// 👍 672 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1, ans = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                    ans = mid;
                    break;
                }
                if (compare(nums, mid, mid + 1) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        public int compare(int[] nums, int idx1, int idx2) {
            int[] num1 = get(nums, idx1);
            int[] num2 = get(nums, idx2);
            if (num1[0] != num2[0]) {
                return num1[0] > num2[0] ? 1 : -1;
            }
            if (num1[1] == num2[1]) {
                return 0;
            }
            return num1[1] > num2[1] ? 1 : -1;
        }

        public int[] get(int[] nums, int idx) {
            if (idx == -1 || idx == nums.length) {
                return new int[]{0, 0};
            }
            return new int[]{1, nums[idx]};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
