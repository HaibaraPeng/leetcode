//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 310 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        solution.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            Collections.sort(dictionary, (a, b) -> {
                if (a.length() != b.length()) {
                    return b.length() - a.length();
                } else {
                    return a.compareTo(b);
                }
            });
            String res = "";
            int sLen = s.length();
            for (String str : dictionary) {
                int strLen = str.length();
                int i = 0, j = 0;
                while (i < sLen && j < strLen) {
                    if (s.charAt(i) == str.charAt(j)) {
                        j++;
                    }
                    i++;
                }
                if (j == strLen) {
                    return str;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}