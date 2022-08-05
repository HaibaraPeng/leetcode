//给定一个正整数数组 nums和一个整数 k ，返回 num 中 「好子数组」 的数目。 
//
// 如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。 
//
// 
// 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。 
// 
//
// 子数组 是数组的 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,2,3], k = 2
//输出：7
//解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,4], k = 3
//输出：3
//解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i], k <= nums.length 
// 
// Related Topics 数组 哈希表 计数 滑动窗口 👍 395 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
        solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            int n = nums.length, res = 0;
            int[] lower = new int[n], upper = new int[n];
            find(lower, nums, k);
            find(upper, nums, k - 1);
            for (int i = 0; i < n; i++) {
                res += (upper[i] - lower[i]);
            }
            return res;
        }

        private void find(int[] arr, int[] nums, int k) {
            int n = nums.length, i = 0, j = 0;
            Map<Integer, Integer> map = new HashMap<>(8);
            for (; j < k - 1; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            for (; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                while (map.size() > k) {
                    int value = map.get(nums[i]) - 1;
                    if (value == 0) {
                        map.remove(nums[i]);
                    } else {
                        map.put(nums[i], value);
                    }
                    i++;
                }
                if (map.size() == k) {
                    arr[j] = i;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}