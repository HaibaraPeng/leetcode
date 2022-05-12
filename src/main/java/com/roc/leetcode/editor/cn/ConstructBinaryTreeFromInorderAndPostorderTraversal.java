//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 630 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        solution.buildTree(new int[]{2, 1}, new int[]{2, 1});
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
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int inSize = inorder.length;
            int postSize = postorder.length;
            if (inSize == 0) return new TreeNode();
            for (int i = 0; i < inSize; i++) {
                inOrderMap.put(inorder[i], i);
            }
            return buildTree(inorder, postorder, 0, inSize - 1, 0, postSize - 1);
        }

        private TreeNode buildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
            TreeNode root = null;
            if (inorderLeft <= inorderRight && postorderLeft <= postorderRight) {
                root = new TreeNode(postorder[postorderRight]);
                int inorderRootIndex = inOrderMap.get(postorder[postorderRight]);
                if (inorderLeft < inorderRight && postorderLeft < postorderRight) {
                    root.left = buildTree(inorder, postorder, inorderLeft, inorderRootIndex - 1, postorderLeft, postorderLeft + inorderRootIndex - 1 - inorderLeft);
                    root.right = buildTree(inorder, postorder, inorderRootIndex + 1, inorderRight, postorderRight - inorderRight + inorderRootIndex, postorderRight - 1);
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
