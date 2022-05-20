//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学 👍 514 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        //输入：l1 = [9,4,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        solution.addTwoNumbers(l1, l2);
    }

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

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 获取l1和l2的长度
            int len1 = 0, len2 = 0;
            ListNode temp1 = l1, temp2 = l2;
            while (temp1 != null || temp2 != null) {
                if (temp1 != null) {
                    len1++;
                    temp1 = temp1.next;
                }
                if (temp2 != null) {
                    len2++;
                    temp2 = temp2.next;
                }
            }
            if (len1 < len2) {
                temp1 = l2;
                temp2 = l1;
            } else {
                temp1 = l1;
                temp2 = l2;
            }
            ListNode res = new ListNode();
            ListNode resTemp = res;
            for (int i = 0; i < Math.abs(len1 - len2); i++) {
                resTemp.next = new ListNode();
                resTemp.next.val = temp1.val;
                resTemp = resTemp.next;
                temp1 = temp1.next;
            }
            for (int i = 0; i < Math.min(len1, len2); i++) {
                resTemp.next = new ListNode();
                resTemp.next.val = temp1.val + temp2.val;
                resTemp = resTemp.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            // 处理进位
            carry(res);
            return res.val > 0 ? res : res.next;
        }

        private int carry(ListNode node) {
            int carryValue = 0;
            if (node.next != null) {
                carryValue = carry(node.next);
            }
            int add = carryValue + node.val;
            int res = 0;
            if (add > 9) {
                res = 1;
            }
            node.val = (carryValue + node.val) % 10;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}