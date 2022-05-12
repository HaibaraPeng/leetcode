//给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 示例 3: 
//
// 
//输入:s = "bb"
//输入: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只能由小写和/或大写英文字母组成 
// 
// Related Topics 贪心 哈希表 字符串 👍 413 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashSet;

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            if (s == null || s.length() == 0) return 0;
            HashSet<Character> set = new HashSet<>();
            int res = 1;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(i));
                    res += 2;
                } else {
                    set.add(s.charAt(i));
                }
            }
            return Math.min(s.length(), res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}