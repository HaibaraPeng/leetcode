//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 👍 461 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode listNode3 = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(solution.partition(listNode1,3));
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
        public ListNode partition(ListNode head, int x) {
            if (head == null) return head;
            ListNode left = new ListNode(-1);
            ListNode right = new ListNode(-1);
            ListNode leftTemp = left;
            ListNode rightTemp = right;
            while (head != null) {
                if (head.val < x) {
                    leftTemp.next = head;
                    leftTemp = leftTemp.next;
                } else {
                    rightTemp.next = head;
                    rightTemp = rightTemp.next;
                }
                head = head.next;
            }
            rightTemp.next = null;
            leftTemp.next = right.next;
            return left.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}