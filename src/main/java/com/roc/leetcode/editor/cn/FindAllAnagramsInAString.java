//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 888 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd", "abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int sLen = s.length(), pLen = p.length();
            if (sLen < pLen) {
                return res;
            }
            Map<Character, Integer> pMap = new HashMap<>(8);
            Map<Character, Integer> sMap = new HashMap<>(8);
            for (int i = 0; i < p.length(); i++) {
                pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            }
            for (int i = 0; i < sLen - pLen + 1; i++) {
                if (i == 0) {
                    for (int j = 0; j < p.length(); j++) {
                        sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
                    }
                } else {
                    sMap.put(s.charAt(i + pLen - 1), sMap.getOrDefault(s.charAt(i + pLen - 1), 0) + 1);
                }
                if (check(sMap, pMap)) {
                    res.add(i);
                }
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
            }
            return res;
        }

        private boolean check(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
            for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
                if (entry.getValue() != 0) {
                    if (!pMap.containsKey(entry.getKey()) || !entry.getValue().equals(pMap.get(entry.getKey()))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}