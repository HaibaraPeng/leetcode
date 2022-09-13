//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 100] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-
//bst/ 相同 
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 234 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.LinkedList;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
    }

    public class TreeNode {
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


        public int minDiffInBST(TreeNode root) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            dfs(linkedList, root);
            int res = Integer.MAX_VALUE;
            int a = linkedList.poll();
            while (!linkedList.isEmpty()) {
                int b = linkedList.poll();
                res = Math.min(Math.abs(a - b), res);
                a = b;
            }
            return res;
        }

        private void dfs(LinkedList<Integer> linkedList, TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(linkedList, root.left);
            linkedList.add(root.val);
            dfs(linkedList, root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}