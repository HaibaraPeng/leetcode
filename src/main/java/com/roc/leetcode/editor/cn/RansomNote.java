//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 105 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 316 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < magazine.length(); i++) {
                map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                Integer res = map.getOrDefault(ransomNote.charAt(i), 0) - 1;
                if (res < 0) return false;
                map.put(ransomNote.charAt(i), res);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}