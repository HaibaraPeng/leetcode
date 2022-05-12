//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 
// 👍 639 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(5);
        solution.binaryTreePaths(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) return res;
            dfs(root, res, new StringBuilder());
            return res;
        }

        private void dfs(TreeNode node, List<String> res, StringBuilder stringBuilder) {
            stringBuilder.append(node.val);
            stringBuilder.append("->");
            int curLen = stringBuilder.length();
            if (node.left == null && node.right == null) {
                String str = stringBuilder.toString();
                res.add(str.substring(0, str.length() - 2));
                return;
            }
            if (node.left != null) {
                dfs(node.left, res, stringBuilder);
                stringBuilder.delete(curLen, stringBuilder.length());
            }
            if (node.right != null) {
                dfs(node.right, res, stringBuilder);
                stringBuilder.delete(curLen, stringBuilder.length());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
