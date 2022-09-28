//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1277 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> list = new ArrayList<>();
            partition(res, list, s, 0);
            return res;
        }

        private void partition(List<List<String>> res, List<String> list, String s, int index) {
            if (index == s.length()) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = index + 1; i <= s.length(); i++) {
                String str = s.substring(index, i);
                if (isPalindrome(str)) {
                    list.add(str);
                    partition(res, list, s, i);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String str) {
            int left = 0, right = str.length() - 1;
            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}