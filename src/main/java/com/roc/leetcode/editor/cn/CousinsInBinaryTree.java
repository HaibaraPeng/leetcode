//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 278 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.right = new TreeNode(5);
        solution.isCousins(root, 1, 3);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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
        public boolean isCousins(TreeNode root, int x, int y) {
            int[] xi = dfs(root, null, 1, x);
            int[] yi = dfs(root, null, 1, y);
            return xi[0] != yi[0] && xi[1] == yi[1];
        }

        private int[] dfs(TreeNode node, TreeNode parent, int deep, int target) {
            if (node == null) {
                return new int[]{0, 0};
            }
            if (node.val == target) {
                if (parent == null) {
                    return new int[]{0, deep};
                }
                return new int[]{parent.val, deep};
            }
            int[] left = dfs(node.left, node, deep + 1, target);
            if (left[0] == 0) {
                return dfs(node.right, node, deep + 1, target);
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}