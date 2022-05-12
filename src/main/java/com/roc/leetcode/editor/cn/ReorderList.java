//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 678 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
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
        public void reorderList(ListNode head) {
            ListNode node1 = head;
            // 获取链表中点
            ListNode mid = getMiddleNode(head);
            ListNode midNext = mid.next;
            mid.next = null;
            // 反转第二条链表
            ListNode node2 = reverseList(midNext);
            // 合并两条链
            merge(node1, node2);
        }

        public ListNode getMiddleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

        public void merge(ListNode node1, ListNode node2) {
            ListNode node1Temp;
            ListNode node2Temp;
            while (node1 != null && node2 != null) {
                node1Temp = node1.next;
                node2Temp = node2.next;
                node1.next = node2;
                node1 = node1Temp;
                node2.next = node1;
                node2 = node2Temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}