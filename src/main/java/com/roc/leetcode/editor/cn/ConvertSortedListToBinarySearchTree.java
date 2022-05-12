//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 
// 👍 631 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;
import com.roc.leetcode.editor.cn.common.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
        ListNode node0 = new ListNode(-10);
        node0.next = new ListNode(-3);
//        node0.next.next = new ListNode(0);
//        node0.next.next.next = new ListNode(5);
//        node0.next.next.next.next = new ListNode(9);
        solution.sortedListToBST(node0);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            int size = 0;
            ListNode temp = head;
            while (temp.next != null) {
                size++;
                temp = temp.next;
            }
            return sortedListToBST(head, 0, size);
        }

        private TreeNode sortedListToBST(ListNode head, int left, int right) {
            if (left > right) return null;
            int mid = left + 1 == right ? right : left + ((right - left) >> 1);
            ListNode temp = head;
            for (int i = 0; i < mid - left; i++) {
                temp = temp.next;
            }
            TreeNode root = new TreeNode(temp.val);
            root.left = sortedListToBST(head, left, mid - 1);
            root.right = sortedListToBST(temp.next, mid + 1, right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
