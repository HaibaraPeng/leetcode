//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 245 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            List<Character> vowelList = new ArrayList<Character>() {
                {
                    add('a');
                }

                {
                    add('e');
                }

                {
                    add('i');
                }

                {
                    add('o');
                }

                {
                    add('u');
                }

                {
                    add('A');
                }

                {
                    add('E');
                }

                {
                    add('I');
                }

                {
                    add('O');
                }

                {
                    add('U');
                }
            };
            int left = 0, right = s.length() - 1;
            char[] chars = s.toCharArray();
            while (left <= right) {
                if (!vowelList.contains(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!vowelList.contains(s.charAt(right))) {
                    right--;
                    continue;
                }
                Character temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            return String.copyValueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}