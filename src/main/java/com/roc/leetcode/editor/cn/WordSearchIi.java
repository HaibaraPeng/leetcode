//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
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
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 709 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
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
        solution.findWords(board, new String[]{"oath", "pea", "eat", "rain"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Node {
            Node[] children = new Node[26];

            public Node addChild(Character c) {
                int index = c - 'a';
                if (children[index] == null) {
                    Node node = new Node();
                    children[index] = node;
                }
                return children[index];
            }
        }

        public List<String> findWords(char[][] board, String[] words) {
            Node root = new Node();
            HashSet<String> set = new HashSet<>(words.length);
            // 构建字典树
            for (String word : words) {
                set.add(word);
                Node temp = root;
                for (int i = 0; i < word.length(); i++) {
                    temp = temp.addChild(word.charAt(i));
                }
            }
            // 递归寻找
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    findWords(board, root, set, res, sb, i, j);
                }
            }
            return res;
        }

        private void findWords(char[][] board, Node root, HashSet<String> set, List<String> res, StringBuilder sb, int x, int y) {
            int m = board.length, n = board[0].length;
            if (x < 0 || x == m || y < 0 || y == n || board[x][y] == '0') {
                return;
            }
            int index = board[x][y] - 'a';
            Node child = root.children[index];
            if (child == null) {
                return;
            }
            sb.append(board[x][y]);
            String str = sb.toString();
            if (set.contains(str)) {
                res.add(str);
                set.remove(str);
            }
            Character temp = board[x][y];
            board[x][y] = '0';
            findWords(board, child, set, res, sb, x - 1, y);
            findWords(board, child, set, res, sb, x, y + 1);
            findWords(board, child, set, res, sb, x + 1, y);
            findWords(board, child, set, res, sb, x, y - 1);
            sb.deleteCharAt(sb.length() - 1);
            board[x][y] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}