//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 1504 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
//        [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(solution.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        List<TreeNode> pParentList = new ArrayList<>();
        List<TreeNode> qParentList = new ArrayList<>();
        Boolean pFlag = false;
        Boolean qFlag = false;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            generateParentList(root, p, q);
            int index = Math.min(pParentList.size(), qParentList.size());
            int res = 0;
            for (int i = 0; i < index; i++) {
                if (pParentList.get(i).val != qParentList.get(i).val) {
                    res = i - 1;
                    break;
                }
                res = i;
            }
            return pParentList.get(res);
        }

        private void generateParentList(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) return;
            if (pFlag && qFlag) return;
            if (!pFlag) pParentList.add(node);
            if (!qFlag) qParentList.add(node);
            if (node.val == p.val) {
                pFlag = true;
            }
            if (node.val == q.val) {
                qFlag = true;
            }
            generateParentList(node.left, p, q);
            generateParentList(node.right, p, q);
            if (!pFlag) pParentList.remove(pParentList.size() - 1);
            if (!qFlag) qParentList.remove(qParentList.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
