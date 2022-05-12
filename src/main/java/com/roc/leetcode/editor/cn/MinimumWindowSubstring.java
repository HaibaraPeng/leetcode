//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1456 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashSet;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] arr = new int[128];
            HashSet<Character> hashSet = new HashSet<>();
            for (int i = 0; i < t.length(); i++) {
                arr[t.charAt(i)]++;
                hashSet.add(t.charAt(i));
            }
            int count = hashSet.size();
            // count表示待匹配字符个数
            int left = 0;
            int right = -1;
            int minL = 0;
            int minLen = Integer.MAX_VALUE;
            while (right < s.length()) {
                if (count == 0) {
                    // 移动左边，尝试缩减长度
                    arr[s.charAt(left)]++;
                    // 左边界每往右移动一个字符，在arr[]中这个字符个数加1
                    if (hashSet.contains(s.charAt(left)) && arr[s.charAt(left)] == 1) {
                        // 如果这个字符在hashSet中，且结果等于1，即表示是从匹配成了变为缺少匹配个数的状态，那么count++;
                        count++;
                    }
                    // 移动左边
                    left++;
                } else {
                    // 移动右边边
                    right++;
                    if (right == s.length()) {
                        break;
                    }
                    arr[s.charAt(right)]--;
                    // 右边界每新增一个字符，在arr[]中减去这个字符个数减1
                    if (hashSet.contains(s.charAt(right)) && arr[s.charAt(right)] == 0) {
                        // 如果这个字符在hashSet中，如果结果为0了表示都匹配到了，则count--;
                        count--;
                    }
                }
                if (count == 0 && right - left < minLen) {
                    // 记下最小字串
                    minLen = right - left;
                    minL = left;
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL + minLen + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
