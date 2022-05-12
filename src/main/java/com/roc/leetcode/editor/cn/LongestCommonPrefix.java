//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1778 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"a", "ab", "bc"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String commonPrefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                if (commonPrefix.equals("")) {
                    break;
                }
                commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
            }
            return commonPrefix;
        }

        public String getCommonPrefix(String str1, String str2) {
            int minLength = Math.min(str1.length(), str2.length());
            int index = 0;
            while (index < minLength) {
                if (str1.charAt(index) != str2.charAt(index)) {
                    break;
                }
                index++;
            }
            return index == 0 ? "" : str1.substring(0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
