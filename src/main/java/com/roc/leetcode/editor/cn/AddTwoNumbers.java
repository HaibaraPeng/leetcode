//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 6834 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode node14 = new ListNode(9);
        ListNode node13 = new ListNode(9, node14);
        ListNode node12 = new ListNode(9, node13);
        ListNode node11 = new ListNode(9, node12);
        ListNode node22 = new ListNode(9);
        ListNode node21 = new ListNode(9, node22);
        ListNode node = solution.addTwoNumbers(node11, node21);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode addNode = new ListNode();
            ListNode head = addNode;
            boolean addOne = false;
            while (l1 != null || l2 != null) {
                int add;
                if (l1 == null) {
                    add = addOne ? l2.val + 1 : l2.val;
                } else if (l2 == null) {
                    add = addOne ? l1.val + 1 : l1.val;
                } else {
                    add = addOne ? l1.val + l2.val + 1 : l1.val + l2.val;
                }
                if (add > 9) {
                    addNode.val = add % 10;
                    addOne = true;
                } else {
                    addNode.val = add;
                    addOne = false;
                }
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                if (l1 != null || l2 != null) {
                    ListNode next = new ListNode();
                    addNode.next = next;
                    addNode = addNode.next;
                }
            }
            if (addOne) {
                ListNode next = new ListNode(1);
                addNode.next = next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}