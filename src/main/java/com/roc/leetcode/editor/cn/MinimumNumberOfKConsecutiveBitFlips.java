//给定一个二进制数组 nums 和一个整数 k 。 
//
// k位翻转 就是从 nums 中选择一个长度为 k 的 子数组 ，同时把子数组中的每一个 0 都改成 1 ，把子数组中的每一个 1 都改成 0 。 
//
// 返回数组中不存在 0 所需的最小 k位翻转 次数。如果不可能，则返回 -1 。 
//
// 子数组 是数组的 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,0], K = 1
//输出：2
//解释：先翻转 A[0]，然后翻转 A[2]。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,0], K = 2
//输出：-1
//解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0,1,0,1,1,0], K = 3
//输出：3
//解释：
//翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
//翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
//翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= k <= nums.length 
// 
// Related Topics 位运算 队列 数组 前缀和 滑动窗口 👍 252 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfKConsecutiveBitFlips().new Solution();
        solution.minKBitFlips(new int[]{1, 1, 0}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minKBitFlips(int[] nums, int k) {
            int n = nums.length;
            int ans = 0;
            int[] arr = new int[n + 1];
            for (int i = 0, cnt = 0; i < n; i++) {
                cnt += arr[i];
                if ((nums[i] + cnt) % 2 == 0) {
                    if (i + k > n) return -1;
                    arr[i + 1]++;
                    arr[i + k]--;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}