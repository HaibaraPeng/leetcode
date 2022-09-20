//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 2113 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, char[]> map = new HashMap<Character, char[]>() {
            {
                put('2', new char[]{'a', 'b', 'c'});
                put('3', new char[]{'d', 'e', 'f'});
                put('4', new char[]{'g', 'h', 'i'});
                put('5', new char[]{'j', 'k', 'l'});
                put('6', new char[]{'m', 'n', 'o'});
                put('7', new char[]{'p', 'q', 'r', 's'});
                put('8', new char[]{'t', 'u', 'v'});
                put('9', new char[]{'w', 'x', 'y', 'z'});
            }
        };

        public List<String> letterCombinations(String digits) {
            char[] chars = digits.toCharArray();
            List<String> res = new ArrayList<>();
            if (!digits.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                letterCombinations(chars, 0, res, sb);
            }
            return res;
        }

        private void letterCombinations(char[] chars, int index, List<String> res, StringBuilder sb) {
            if (index == chars.length) {
                res.add(sb.toString());
                sb.deleteCharAt(index - 1);
                return;
            }
            char[] arr = map.get(chars[index]);
            for (char c : arr) {
                letterCombinations(chars, index + 1, res, sb.append(c));
            }
            if (index > 0) {
                sb.deleteCharAt(index - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}