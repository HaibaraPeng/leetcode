//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 二分查找 有序集合 单调栈 👍 662 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
        solution.find132pattern(new int[]{3,1,4,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            Deque<Integer> candidateK = new LinkedList<>();
            candidateK.push(nums[n - 1]);
            int maxK = Integer.MIN_VALUE;

            for (int i = n - 2; i >= 0; --i) {
                if (nums[i] < maxK) {
                    return true;
                }
                while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                    maxK = candidateK.pop();
                }
                if (nums[i] > maxK) {
                    candidateK.push(nums[i]);
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}