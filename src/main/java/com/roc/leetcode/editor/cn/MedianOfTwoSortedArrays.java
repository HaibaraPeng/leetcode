//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5760 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            int n = n1 + n2;
            if (n % 2 == 1) {
                return find(nums1, 0, n1, nums2, 0, n2, n / 2 + 1);
            } else {
                int a = find(nums1, 0, n1, nums2, 0, n2, n / 2);
                int b = find(nums1, 0, n1, nums2, 0, n2, n / 2 + 1);
                return (a + b) / 2.0;
            }
        }

        private int find(int[] nums1, int i1, int n1, int[] nums2, int i2, int n2, int k) {
            if (n1 - i1 > n2 - i2) {
                return find(nums2, i2, n2, nums1, i1, n1, k);
            }
            if (i1 >= n1) {
                return nums2[i2 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i1], nums2[i2]);
            }
            int mid1 = Math.min(i1 + k / 2, n1);
            int mid2 = i2 + k - k / 2;
            if (nums1[mid1 - 1] > nums2[mid2 - 1]) {
                return find(nums1, i1, n1, nums2, mid2, n2, k - (mid2 - i2));
            } else {
                return find(nums1, mid1, n1, nums2, i2, n2, k - (mid1 - i1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}