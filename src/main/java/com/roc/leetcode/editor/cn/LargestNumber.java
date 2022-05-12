//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 贪心 字符串 排序 
// 👍 849 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        solution.largestNumber(new int[]{3, 30, 34, 5, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] ss = new String[n];
            for (int i = 0; i < n; i++) {
                ss[i] = "" + nums[i];
            }
            Arrays.sort(ss, (a, b) -> {
                String sa = a + b, sb = b + a;
                return sb.compareTo(sa);
            });

            StringBuilder sb = new StringBuilder();
            for (String s : ss) sb.append(s);
            int len = sb.length();
            int k = 0;
            while (k < len - 1 && sb.charAt(k) == '0') {
                k++;
            }
            return sb.substring(k);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
