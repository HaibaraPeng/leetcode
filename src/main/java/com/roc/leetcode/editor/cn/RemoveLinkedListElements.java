//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 704 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        ListNode listNode8 = new ListNode(4);
        ListNode listNode7 = new ListNode(2, listNode8);
        ListNode listNode6 = new ListNode(2, listNode7);
        ListNode listNode5 = new ListNode(3, listNode6);
        ListNode listNode4 = new ListNode(2, listNode5);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode node = solution.removeElements(listNode1, 2);
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode firstNode = new ListNode(0);
            firstNode.next = head;
            ListNode tempNode = firstNode;
            while (tempNode.next != null) {
                if (tempNode.next.val == val) {
                    tempNode.next = tempNode.next.next;
                } else {
                    tempNode = tempNode.next;
                }
            }
            return firstNode.next;
        }


//        public ListNode removeElements(ListNode head, int val) {
//            if (head == null) {
//                return null;
//            }
//            if (head.val == val) {
//                return removeElements(head.next, val);
//            }
//            head.next = removeElements(head.next, val);
//            return head;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
