//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 636 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode node = solution.rotateRight(listNode1, 6);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) return head;
            // 尾节点
            ListNode last = head;
            // 链表长度
            int n = 1;
            while (last.next != null) {
                n++;
                last = last.next;
            }
            // 尾节点连接head
            last.next = head;
            // 断开的索引值
            int index = n - (k % n);
            ListNode temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            ListNode result = temp.next;
            temp.next = null;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}