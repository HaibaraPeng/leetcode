//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 740 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("horse", "ros");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 > len2) {
                return false;
            }
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            for (int i = 0; i < len1; i++) {
                arr1[chars1[i] - 'a']++;
            }
            for (int i = 0; i < len1 - 1; i++) {
                arr2[chars2[i] - 'a']++;
            }
            for (int i = len1 - 1; i < len2; i++) {
                arr2[chars2[i] - 'a']++;
                int index = 0;
                for (; index < 26; index++) {
                    if (arr1[index] != arr2[index]) {
                        break;
                    }
                }
                if (index == 26) {
                    return true;
                }
                arr2[chars2[i + 1 - len1] - 'a']--;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}