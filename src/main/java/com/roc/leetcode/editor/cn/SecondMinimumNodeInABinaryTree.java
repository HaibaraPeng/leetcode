//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。 
//
// 如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 2³¹ - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 272 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Arrays;

public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        solution.findSecondMinimumValue(root);
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
        public int findSecondMinimumValue(TreeNode root) {
            if (root.left == null) {
                return -1;
            }
            int left = root.left.val;
            int right = root.right.val;
            int leftSecond = cur(root.left);
            int rightSecond = cur(root.right);
            int[] arr = new int[4];
            arr[0] = left;
            arr[1] = right;
            arr[2] = leftSecond;
            arr[3] = rightSecond;
            Arrays.sort(arr);
            for (int i = 1; i < 4; i++) {
                if (arr[i] > arr[0]) {
                    return arr[i];
                }
            }
            return -1;
        }

        private int cur(TreeNode root) {
            if (root.left == null) {
                return root.val;
            }

            int[] arr = new int[4];
            arr[0] = root.left.val;
            arr[1] = root.right.val;
            arr[2] = cur(root.left);
            arr[3] = cur(root.right);
            Arrays.sort(arr);
            for (int i = 1; i < 4; i++) {
                if (arr[i] > arr[0]) {
                    return arr[i];
                }
            }
            return arr[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}