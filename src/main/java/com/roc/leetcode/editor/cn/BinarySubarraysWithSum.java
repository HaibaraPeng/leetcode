//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 👍 248 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new BinarySubarraysWithSum().new Solution();
        solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            Map<Integer, Integer> map = new HashMap<>(8);
            map.put(0, 1);
            int res = 0;
            for (int i = 0; i < n; i++) {
                int r = sum[i + 1], l = r - goal;
                res += map.getOrDefault(l, 0);
                map.put(r, map.getOrDefault(r, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}