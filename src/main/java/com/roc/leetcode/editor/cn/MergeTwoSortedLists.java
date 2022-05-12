//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1920 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import com.roc.leetcode.editor.cn.common.ListNode;

/**
 * 步骤1
 * l1 1 3 5
 * l2 2 4 6
 * <p>
 * 步骤2
 * l1 2 4 6
 * l2 1 3 5
 * <p>
 * 步骤3
 * l1 4 6
 * l2 1 2 3 5
 * <p>
 * 步骤4
 * l1 6
 * l2 1 2 3 4 5
 * <p>
 * 步骤3
 * l1
 * l2 1 2 3 4 5 6
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l13 = new ListNode(5);
        ListNode l12 = new ListNode(3, l13);
        ListNode l11 = new ListNode(1, l12);
        ListNode l23 = new ListNode(6);
        ListNode l22 = new ListNode(4, l23);
        ListNode l21 = new ListNode(2, l22);
        solution.mergeTwoLists(l11, l21);
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }

//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            } else if (l2 == null) {
//                return l1;
//            } else if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//        }
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null && l2 == null) {
//                return null;
//            }
//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            if (l1.val >= l2.val) {
//                return mergeSortTwoLists(l1, l2);
//            } else {
//                return mergeSortTwoLists(l2, l1);
//            }
//        }
//
//        public ListNode mergeSortTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            }
//            ListNode node = l2;
//            boolean added = false;
//            while (node.next != null) {
//                if (node.next.val >= l1.val) {
//                    ListNode insert = new ListNode(l1.val);
//                    ListNode temp = node.next;
//                    node.next = insert;
//                    insert.next = temp;
//                    added = true;
//                    break;
//                }
//                node = node.next;
//            }
//            if (added) {
//                return mergeSortTwoLists(l1.next, l2);
//            } else {
//                node.next = l1;
//                return mergeSortTwoLists(null, l2);
//            }
//        }
    }
}
