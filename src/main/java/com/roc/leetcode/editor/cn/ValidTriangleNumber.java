//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,2,3,4]
//输出: 3
//解释:有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,3,4]
//输出: 4 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 424 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        solution.triangleNumber(new int[]{2, 2, 3, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int res = 0, len = nums.length;
            if (len < 3) {
                return res;
            }
            for (int i = 0; i < len; i++) {
                for (int j = i - 1, k = 0; k < j; j--) {
                    while (k < j && nums[k] + nums[j] <= nums[i]) {
                        k++;
                    }
                    res += (j - k);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}