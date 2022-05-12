//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 回溯 
// 👍 544 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<String>() {
            {
                add("cat");
                add("cats");
                add("and");
                add("sand");
                add("dog");
            }
        };
        System.out.println(Arrays.toString(solution.wordBreak(s, wordDict).toArray()));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            Set<String> set = new HashSet<>(wordDict);
            int[][] dp = new int[len][len];
            for (int i = 1; i < len + 1; i++) {
                for (int j = 0; j < i; j++) {
                    dp[j][i - 1] = set.contains(s.substring(j, i)) ? 1 : 2;
                }
            }
            List<String> res = new ArrayList<>();
            wordBreak(res, s, dp, new StringBuilder(), 0, len);
            return res;
        }

        private void wordBreak(List<String> res, String s, int[][] dp, StringBuilder sb, int index, int len) {
            if (index == len) {
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
                sb.append(" ");
                return;
            }
            for (int i = index; i < len; i++) {
                if (dp[index][i] == 1) {
                    sb.append(s, index, i + 1);
                    sb.append(" ");
                    wordBreak(res, s, dp, sb, i + 1, len);
                    sb.delete(sb.length() - (i + 1 - index) - 1, sb.length());
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
