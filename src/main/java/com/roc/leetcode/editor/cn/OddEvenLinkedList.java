//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 104 
// -106 <= Node.val <= 106 
// 
// Related Topics 链表 
// 👍 574 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
        //输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4]
        ListNode root = new ListNode(2);
        root.next = new ListNode(1);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(7);
        solution.oddEvenList(root);
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
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode root = new ListNode(head.val);
            ListNode node = root, temp = head;
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next.next;
                node.next = new ListNode(temp.val);
                node = node.next;
            }
            if (head.next != null) {
                head = head.next;
                node.next = new ListNode(head.val);
                node = node.next;
                while (head.next != null && head.next.next != null) {
                    head = head.next.next;
                    node.next = new ListNode(head.val);
                    node = node.next;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}