//给你两个长度相同的字符串，s 和 t。 
//
// 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的
//绝对值。 
//
// 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。 
//
// 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。 
//
// 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "bcdf", maxCost = 3
//输出：3
//解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。 
//
// 示例 2： 
//
// 
//输入：s = "abcd", t = "cdef", maxCost = 3
//输出：1
//解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcd", t = "acde", maxCost = 0
//输出：1
//解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10^5 
// 0 <= maxCost <= 10^6 
// s 和 t 都只含小写英文字母。 
// 
// Related Topics 字符串 二分查找 前缀和 滑动窗口 👍 175 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        Solution solution = new GetEqualSubstringsWithinBudget().new Solution();
        solution.equalSubstring("ujteygggjwxnfl", "nstsenrzttikoy", 43);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            int n = s.length(), res = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Math.abs(sChars[i] - tChars[i]);
            }
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + arr[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                int left = 0, right = i;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (sum[i] - sum[mid] > maxCost) {
                        left = mid + 1;
                    } else {
                        res = Math.max(res, i - mid);
                        right = mid - 1;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}