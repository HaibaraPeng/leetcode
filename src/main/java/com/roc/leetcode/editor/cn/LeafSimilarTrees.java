//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,
//null,null,null,null,9,8]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,2,3], root2 = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定的两棵树结点数在 [1, 200] 范围内 
// 给定的两棵树上的值在 [0, 200] 范围内 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 195 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.LinkedList;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        Solution solution = new LeafSimilarTrees().new Solution();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(2);
        root1.right.right.left = new TreeNode(9);
        root1.right.right.right = new TreeNode(11);
        root1.right.right.right.left = new TreeNode(8);
        root1.right.right.right.right = new TreeNode(10);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(8);
        root2.left.right.left = new TreeNode(7);
        root2.left.right.right = new TreeNode(4);
        solution.leafSimilar(root1, root2);
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            LinkedList<Integer> linkedList1 = new LinkedList<>();
            LinkedList<Integer> linkedList2 = new LinkedList<>();
            dfs(root1, linkedList1);
            dfs(root2, linkedList2);
            if (linkedList1.size() != linkedList2.size()) {
                return false;
            }
            while (!linkedList1.isEmpty()) {
                if (!linkedList1.poll().equals(linkedList2.poll())) {
                    return false;
                }
            }
            return true;
        }

        private void dfs(TreeNode node, LinkedList<Integer> linkedList) {
            if (node.left != null) {
                dfs(node.left, linkedList);
            }
            if (node.right != null) {
                dfs(node.right, linkedList);
            }
            if (node.left == null && node.right == null) {
                linkedList.add(node.val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}