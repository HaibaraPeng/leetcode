//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1336 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        //输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//
//示例 2：
//
//
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            int step = (numRows - 1) << 1;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < s.length(); j += step) {
                    result.append(s.charAt(j));
                    if (j % (numRows - 1) != 0 && j + step - i - i < s.length()) {
                        result.append(s.charAt(j + step - i - i));
                    }
                }
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // -------------- 按行排序 --------------------
//    public String convert(String s, int numRows) {
//        if (numRows == 1) return s;
//        if (s == null || s.length() <= numRows) return s;
//        // 记录每行字符
//        List<StringBuilder> rows = new ArrayList<>();
//        for (int i = 0; i < numRows; i++)
//            rows.add(new StringBuilder());
//        // 行数上下
//        boolean goingDown = false;
//        int curRow = 0;
//        for (char c : s.toCharArray()) {
//            rows.get(curRow).append(c);
//            goingDown = curRow % (numRows - 1) == 0 ? !goingDown : goingDown;
//            curRow = goingDown ? curRow + 1 : curRow - 1;
//        }
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < rows.size(); i++) {
//            result.append(rows.get(i));
//        }
//        return result.toString();
//    }

    // -------- 按行访问 ----------
//    public String convert(String s, int numRows) {
//        if (numRows == 1) return s;
//        int step = (numRows - 1) << 1;
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < numRows; i++) {
//            for (int j = i; j < s.length(); j += step) {
//                result.append(s.charAt(j));
//                if (j % (numRows - 1) != 0 && j + step - i - i < s.length()) {
//                    result.append(s.charAt(j + step - i - i));
//                }
//            }
//        }
//        return result.toString();
//    }

}
