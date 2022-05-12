//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 链表 排序 👍 436 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();
        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node0 = new ListNode(4, node1);
        ListNode node = solution.insertionSortList(node0);
        System.out.println(node.val);
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
        public ListNode insertionSortList(ListNode head) {
            if (head == null) return null;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode lastSortNode = head;
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val > lastSortNode.val) {
                    lastSortNode = lastSortNode.next;
                } else {
                    ListNode temp = dummy;
                    while (temp.next.val < cur.val) {
                        temp = temp.next;
                    }
                    ListNode tempNext = temp.next;
                    ListNode curNext = cur.next;
                    temp.next = cur;
                    cur.next = tempNext;
                    lastSortNode.next = curNext;
                }
                cur = lastSortNode.next;
            }
            return dummy.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}