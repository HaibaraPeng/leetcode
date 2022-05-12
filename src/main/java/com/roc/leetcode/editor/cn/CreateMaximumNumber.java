//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 栈 贪心 单调栈 
// 👍 447 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class CreateMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new CreateMaximumNumber().new Solution();
        solution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[] res = new int[k];
            int max = 0, len1 = nums1.length, len2 = nums2.length;
            for (int i = Math.max(0, k - len2); i <= Math.min(len1, k); i++) {
                int[] arr1 = maxSubSequence(nums1, i);
                int[] arr2 = maxSubSequence(nums2, k - i);
                int[] mergeArr = merge(arr1, arr2);
                if (compare(mergeArr, 0, res, 0) > 0)
                    System.arraycopy(mergeArr, 0, res, 0, k);
            }
            return res;
        }

        private int[] merge(int[] arr1, int[] arr2) {
            int len1 = arr1.length, len2 = arr2.length, index1 = 0, index2 = 0;
            if (len1 == 0) return arr2;
            if (len2 == 0) return arr1;

            int[] res = new int[len1 + len2];
            for (int i = 0; i < len1 + len2; i++) {
                if (compare(arr1, index1, arr2, index2) > 0) {
                    res[i] = arr1[index1++];
                } else {
                    res[i] = arr2[index2++];
                }
            }
            return res;
        }

        private int compare(int[] arr1, int index1, int[] arr2, int index2) {
            int x = arr1.length, y = arr2.length;
            while (index1 < x && index2 < y) {
                int diff = arr1[index1] - arr2[index2];
                if (diff != 0) return diff;
                index1++;
                index2++;
            }
            return (x - index1) - (y - index2);
        }

        public int[] maxSubSequence(int[] arr, int k) {
            int length = arr.length;
            int[] stack = new int[k];
            int top = -1;
            int remain = length - k;
            for (int i = 0; i < length; i++) {
                int num = arr[i];
                while (top >= 0 && stack[top] < num && remain > 0) {
                    top--;
                    remain--;
                }
                if (top < k - 1) {
                    stack[++top] = num;
                } else {
                    remain--;
                }
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
