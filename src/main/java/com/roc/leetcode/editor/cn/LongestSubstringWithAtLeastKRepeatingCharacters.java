//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 714 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        solution.longestSubstring("ababbc", 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            int len = s.length();
            char[] chars = s.toCharArray();
            int res = 0;
            for (int i = 1; i < 27; i++) {
                int[] arr = new int[26];
                int total = 0, sum = 0;
                for (int l = 0, r = 0; r < len; r++) {
                    int rvalue = chars[r] - 'a';
                    if (arr[rvalue]++ == 0) {
                        total++;
                    }
                    if (arr[rvalue] == k) {
                        sum++;
                    }
                    while (total > i) {
                        int lvalue = chars[l++] - 'a';
                        if (--arr[lvalue] == 0) {
                            total--;
                        }
                        if (arr[lvalue] == k - 1) {
                            sum--;
                        }
                    }
                    if (total == sum) {
                        res = Math.max(res, r - l + 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}