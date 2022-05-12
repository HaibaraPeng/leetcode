//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 
// 👍 603 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[]{"oath", "pea", "rain", "hklf", "hf" ,"eat"};
        solution.findWords(board, words);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Trie {
            private Trie[] children;
            private boolean isEnd;

            public Trie() {
                this.children = new Trie[26];
                this.isEnd = false;
            }

            public void insert(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new Trie();
                    }
                    node = node.children[index];
                }
                node.isEnd = true;
            }
        }

        private List<String> res = new ArrayList<>();

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            // 将words放入字典树中
            for (int i = 0; i < words.length; i++) {
                trie.insert(words[i]);
            }
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    findWords(new StringBuilder(), trie, board, m, n, i, j);
                }
            }
            return res;
        }

        private void findWords(StringBuilder stringBuilder, Trie trie, char[][] board, int m, int n, int row, int col) {
            if (board[row][col] == '0') return;
            int index = board[row][col] - 'a';
            if (trie.children[index] == null) return;
            stringBuilder.append(board[row][col]);
            char temp = board[row][col];
            board[row][col] = '0';
            trie = trie.children[index];
            if (trie.isEnd && !res.contains(stringBuilder.toString())) {
                res.add(stringBuilder.toString());
            }

            if (row > 0) findWords(stringBuilder, trie, board, m, n, row - 1, col);
            if (row < m - 1) findWords(stringBuilder, trie, board, m, n, row + 1, col);
            if (col > 0) findWords(stringBuilder, trie, board, m, n, row, col - 1);
            if (col < n - 1) findWords(stringBuilder, trie, board, m, n, row, col + 1);
            board[row][col] = temp;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
