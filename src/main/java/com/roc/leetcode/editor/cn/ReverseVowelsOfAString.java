////给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
////
//// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "hello"
////输出："holle"
//// 
////
//// 示例 2： 
////
//// 
////输入：s = "leetcode"
////输出："leotcede" 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= s.length <= 3 * 10⁵ 
//// s 由 可打印的 ASCII 字符组成 
//// 
//// Related Topics 双指针 字符串 👍 253 👎 0
//

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        solution.reverseVowels("leetcode");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');
            int left = 0, right = chars.length - 1;
            while (left <= right) {
                Character a = chars[left];
                Character b = chars[right];
                if (set.contains(a) && set.contains(b)) {
                    Character temp = a;
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                } else {
                    if (!set.contains(a)) {
                        left++;
                    }
                    if (!set.contains(b)) {
                        right--;
                    }
                }
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}