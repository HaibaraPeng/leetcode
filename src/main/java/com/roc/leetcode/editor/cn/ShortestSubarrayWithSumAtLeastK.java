//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -105 <= nums[i] <= 105 
// 1 <= k <= 109 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 
// 👍 363 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
        System.out.println(solution.shortestSubarray(new int[]{1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] p = new long[n + 1];
            for (int i = 0; i < n; i++) {
                p[i + 1] = p[i] + (long) nums[i];
            }

            // want smallest y-x with p[y] - p[x] >= k
            int ans = n + 1; // n+1 is impossible
            Deque<Integer> monoq = new LinkedList<>();

            for (int y = 0; y < p.length; y++) {
                // want opt(y) = largest x with p[x] <= p[y] - k;
                while (!monoq.isEmpty() && p[y] <= p[monoq.getLast()]) {
                    monoq.removeLast();
                }
                while (!monoq.isEmpty() && p[y] >= p[monoq.getFirst()] + k) {
                    ans = Math.min(ans, y - monoq.removeFirst());
                }
                monoq.addLast(y);
            }
            return ans < n + 1 ? ans : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
