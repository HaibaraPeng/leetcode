//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 492 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            linkedList.offer(root);
            while (!linkedList.isEmpty()) {
                int size = linkedList.size();
                LinkedList<Integer> temp = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode popNode = linkedList.pop();
                    temp.offer(popNode.val);
                    if (popNode.left != null) linkedList.offer(popNode.left);
                    if (popNode.right != null) linkedList.offer(popNode.right);
                }
                res.offerFirst(temp);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
