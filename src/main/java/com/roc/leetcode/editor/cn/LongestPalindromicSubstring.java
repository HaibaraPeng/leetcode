//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4254 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("abcbacd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0 || s.length() == 1) return s;
            // 添加特殊字符
            s = addSign(s);
            // 最长回文中心位置索引
            int C = -1;
            // 最长回文右边界
            int R = -1;
            // 回文半径数组
            int[] pArray = new int[s.length()];
            int maxPArrayIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                pArray[i] = R > i ? pArray[Math.min(C << 1 - i, R - i)] : 1;
                while ((i + pArray[i]) < s.length() && (i - pArray[i]) > -1) {
                    if (s.charAt(i + pArray[i]) == s.charAt(i - pArray[i])) {
                        pArray[i]++;
                    } else {
                        break;
                    }
                }
                if (pArray[i] > (R - C)) {
                    C = i + pArray[i];
                    R = pArray[i];
                }
                maxPArrayIndex = pArray[maxPArrayIndex] < pArray[i] ? i : maxPArrayIndex;
            }
            System.out.println(Arrays.toString(pArray));
            System.out.println(maxPArrayIndex);
            return s.substring(maxPArrayIndex + 1 - pArray[maxPArrayIndex], maxPArrayIndex + pArray[maxPArrayIndex]).replace("#", "");
        }

        public String addSign(String str) {
            if (str == null || str.length() == 0) return str;
            StringBuilder stringBuilder = new StringBuilder("#");
            for (int i = 0; i < str.length(); i++) {
                stringBuilder.append(str.charAt(i) + "#");
            }
            return stringBuilder.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //  --------------------------普通方法--------------------------

//    public String longestPalindrome(String s) {
//        if (s == null || s.length() == 0 || s.length() == 1) return s;
//        // 添加特殊字符
//        s = addSign(s);
//        String longest = "";
//        for (int i = 1; i < s.length() - 1; i++) {
//            // 获取i处最长回文数
//            String temp = getIndexLongestPalindromic(s, i);
//            if (temp.length() > longest.length()) longest = temp;
//        }
//        return longest.replace("#", "");
//    }
//
//    public String addSign(String str) {
//        if (str == null || str.length() == 0) return str;
//        StringBuilder stringBuilder = new StringBuilder("#");
//        for (int i = 0; i < str.length(); i++) {
//            stringBuilder.append(str.charAt(i) + "#");
//        }
//        return stringBuilder.toString();
//    }
//
//    public String getIndexLongestPalindromic(String str, int index) {
//        int left = index - 1;
//        int right = index + 1;
//        while (left >= 0 && right < str.length()) {
//            if (str.charAt(left) != str.charAt(right)) {
//                break;
//            }
//            left--;
//            right++;
//        }
//        return str.substring(left + 1, right);
//    }

    // ------------------------动态规划----------------------
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() == 0 || s.length() == 1) return s;
//        int[][] array = new int[s.length()][s.length()];
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][j] = -1;
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j < array[i].length; j++) {
//                updatePalindromeArray(array, s, i, j);
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(Arrays.toString(array[i]));
//        }
//        return null;
//    }
//
//    public int updatePalindromeArray(int[][] array, String str, int left, int right) {
//        if (left == right) {
//            array[left][right] = str.charAt(left) == str.charAt(right) ? 1 : 0;
//        } else {
//            if (left + 1 == right) {
//                array[left][right] = str.charAt(left) == str.charAt(right) ? 2 : 0;
//            } else {
//                if (str.charAt(left) == str.charAt(right)) {
//                    array[left][right] =
//                            array[left + 1][right - 1] != -1 ? array[left + 1][right - 1] + 2 :
//                                    updatePalindromeArray(array, str, left + 1, right - 1) + 2;
//                } else {
//                    array[left][right] = array[left + 1][right - 1] != -1 ? array[left + 1][right - 1] :
//                            updatePalindromeArray(array, str, left + 1, right - 1);
//                }
//            }
//        }
//        return array[left][right];
//    }

    // -----------------------Manacher算法-------------------
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() == 0 || s.length() == 1) return s;
//        // 添加特殊字符
//        s = addSign(s);
//        // 最长回文中心位置索引
//        int C = -1;
//        // 最长回文右边界
//        int R = -1;
//        // 回文半径数组
//        int[] pArray = new int[s.length()];
//        int maxPArrayIndex = 0;
//        for (int i = 0; i < s.length(); i++) {
//            pArray[i] = R > i ? pArray[Math.min(C << 1 - i, R - i)] : 1;
//            while ((i + pArray[i]) < s.length() && (i - pArray[i]) > -1) {
//                if (s.charAt(i + pArray[i]) == s.charAt(i - pArray[i])) {
//                    pArray[i]++;
//                } else {
//                    break;
//                }
//            }
//            if (pArray[i] > (R - C)) {
//                C = i + pArray[i];
//                R = pArray[i];
//            }
//            maxPArrayIndex = pArray[maxPArrayIndex] < pArray[i] ? i : maxPArrayIndex;
//        }
//        System.out.println(Arrays.toString(pArray));
//        System.out.println(maxPArrayIndex);
//        return s.substring(maxPArrayIndex + 1 - pArray[maxPArrayIndex], maxPArrayIndex + pArray[maxPArrayIndex]).replace("#", "");
//    }
//
//    public String addSign(String str) {
//        if (str == null || str.length() == 0) return str;
//        StringBuilder stringBuilder = new StringBuilder("#");
//        for (int i = 0; i < str.length(); i++) {
//            stringBuilder.append(str.charAt(i) + "#");
//        }
//        return stringBuilder.toString();
//    }


}
