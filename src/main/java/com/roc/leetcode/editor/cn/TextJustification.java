//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
// 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 注意: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["This", "is", "an", "example", "of", "text", "justification."], 
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 
//输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 
//输入:words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
//0
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] 由小写英文字母和符号组成 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
// Related Topics 数组 字符串 模拟 👍 286 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            int len = words.length;
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < len; ) {
                temp.clear();
                // 向temp中装入word
                int tempLen = -1;
                int curWordLen = words[i].length() + 1;

                while (tempLen + curWordLen <= maxWidth) {
                    temp.add(words[i++]);
                    tempLen += curWordLen;
                    if (i == len) {
                        break;
                    }
                    curWordLen = words[i].length() + 1;
                }

                // 如果为最后一个单词需要左对齐
                if (i == len) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < temp.size(); j++) {
                        sb.append(temp.get(j));
                        if (j != temp.size() - 1) {
                            sb.append(' ');
                        }
                    }
                    int addSpace = maxWidth - sb.length();
                    for (int j = 0; j < addSpace; j++) {
                        sb.append(' ');
                    }
                    res.add(sb.toString());
                    break;
                }

                // 如果temp中只有一个单词，需要左对齐
                if (temp.size() == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(temp.get(0));
                    int addSpace = maxWidth - sb.length();
                    for (int j = 0; j < addSpace; j++) {
                        sb.append(' ');
                    }
                    res.add(sb.toString());
                    continue;
                }

                // 普通情况
                StringBuilder sb = new StringBuilder();
                // 计算单词总长度
                int wordsLen = 0;
                for (int j = 0; j < temp.size(); j++) {
                    wordsLen += temp.get(j).length();
                }
                // 计算平均空格数量
                int averageSpace = (maxWidth - wordsLen) / (temp.size() - 1);
                // 计算剩下空格数量
                int leftSpace = (maxWidth - wordsLen) % (temp.size() - 1);
                for (int j = 0; j < temp.size(); j++) {
                    sb.append(temp.get(j));
                    int space = averageSpace;
                    if (leftSpace > 0) {
                        space++;
                        leftSpace--;
                    }
                    if (j < temp.size() - 1) {
                        for (int k = 0; k < space; k++) {
                            sb.append(' ');
                        }
                    }
                }
                res.add(sb.toString());
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}