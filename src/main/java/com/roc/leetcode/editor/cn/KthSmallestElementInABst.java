//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 559 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestElementInABst {
    public static void main(String[] args) {
//        [5,3,6,2,4,null,null,1]
        Solution solution = new KthSmallestElementInABst().new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        solution.kthSmallest(root, 1);
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
        public int kthSmallest(TreeNode root, int k) {
            MyBst bst = new MyBst(root);
            return bst.kthSmallest(k);
        }

        class MyBst {
            TreeNode root;
            Map<TreeNode, Integer> nodeNum;

            public MyBst(TreeNode root) {
                this.root = root;
                this.nodeNum = new HashMap<TreeNode, Integer>();
                countNodeNum(root);
            }

            // 返回二叉搜索树中第k小的元素
            public int kthSmallest(int k) {
                TreeNode node = root;
                while (node != null) {
                    int left = getNodeNum(node.left);
                    if (left < k - 1) {
                        node = node.right;
                        k -= left + 1;
                    } else if (left == k - 1) {
                        break;
                    } else {
                        node = node.left;
                    }
                }
                return node.val;
            }

            // 统计以node为根结点的子树的结点数
            private int countNodeNum(TreeNode node) {
                if (node == null) {
                    return 0;
                }
                nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
                return nodeNum.get(node);
            }

            // 获取以node为根结点的子树的结点数
            private int getNodeNum(TreeNode node) {
                return nodeNum.getOrDefault(node, 0);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
