//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 702 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        solution.repeatedSubstringPattern("abcabcabcabc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            StringBuilder sb = new StringBuilder();
            retry:
            for (int i = 0; i < s.length() - 1; i++) {
                sb.append(s.charAt(i));
                String str = sb.toString();
                int len = sb.length();
                if (s.length() % len == 0) {
                    for (int j = 0; j < s.length(); j += len) {
                        if (!str.equals(s.substring(j, j + len))) {
                            continue retry;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}