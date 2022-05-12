//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针 👍 1585 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode listNode8 = new ListNode(4);
        ListNode listNode7 = new ListNode(2, listNode8);
        ListNode listNode6 = new ListNode(2, listNode7);
        ListNode listNode5 = new ListNode(3, listNode6);
        ListNode listNode4 = new ListNode(2, listNode5);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode node = solution.removeNthFromEnd(listNode1, 3);
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

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode zeroNode = new ListNode(0, head);
            int distance = 0;
            ListNode secondNode = zeroNode;
            while (head != null) {
                head = head.next;
                if (distance < n) {
                    distance++;
                } else if (distance == n) {
                    secondNode = secondNode.next;
                }
            }
            secondNode.next = secondNode.next.next;
            return zeroNode.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}