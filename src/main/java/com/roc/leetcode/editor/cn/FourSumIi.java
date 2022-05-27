//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
// Related Topics 数组 哈希表 👍 579 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FourSumIi {
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        solution.fourSumCount(
                new int[]{-1, 1, 1, 1, -1},
                new int[]{0, -1, -1, 0, 1},
                new int[]{-1, -1, 1, -1, -1},
                new int[]{0, 1, 0, -1, -1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
            for (int u : nums1) {
                for (int v : nums2) {
                    countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
                }
            }
            int ans = 0;
            for (int u : nums3) {
                for (int v : nums4) {
                    if (countAB.containsKey(-u - v)) {
                        ans += countAB.get(-u - v);
                    }
                }
            }
            return ans;

//            Map<Integer, Integer> map1 = new HashMap<>(8);
//            Map<Integer, Integer> map2 = new HashMap<>(8);
//            Map<Integer, Integer> map3 = new HashMap<>(8);
//            Map<Integer, Integer> map4 = new HashMap<>(8);
//            for (int i = 0; i < nums1.length; i++) {
//                map1.put(0 - nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
//            }
//            for (int i = 0; i < nums2.length; i++) {
//                map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
//            }
//            for (int i = 0; i < nums3.length; i++) {
//                map3.put(nums3[i], map3.getOrDefault(nums3[i], 0) + 1);
//            }
//            for (int i = 0; i < nums4.length; i++) {
//                map4.put(nums4[i], map4.getOrDefault(nums4[i], 0) + 1);
//            }
//            int res = 0;
//            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
//                for (Map.Entry<Integer, Integer> entry3 : map3.entrySet()) {
//                    for (Map.Entry<Integer, Integer> entry4 : map4.entrySet()) {
//                        int key = entry2.getKey() + entry3.getKey() + entry4.getKey();
//                        if (map1.containsKey(key)) {
//                            res += (map1.get(key) * entry2.getValue() * entry3.getValue() * entry4.getValue());
//                        }
//                    }
//                }
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}