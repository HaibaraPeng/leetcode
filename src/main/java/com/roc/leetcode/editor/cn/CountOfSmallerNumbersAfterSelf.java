//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 n
//ums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 
// 👍 758 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        solution.countSmaller(new int[]{5, 2, 6, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] c;
        private int[] a;

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new ArrayList<>();
            discretization(nums);
            init(nums.length + 5);
            for (int i = nums.length - 1; i >= 0; i--) {
                int id = getId(nums[i]);
                res.add(query(id - 1));
                update(id);
            }
            Collections.reverse(res);
            return res;
        }

        private void update(int pos) {
            while (pos < c.length) {
                c[pos] += 1;
                pos += lowBit(pos);
            }
        }

        private Integer query(int pos) {
            int ret = 0;
            while (pos > 0) {
                ret += c[pos];
                pos -= lowBit(pos);
            }
            return ret;
        }

        private int lowBit(int x) {
            return x & (-x);
        }

        private int getId(int num) {
            return Arrays.binarySearch(a, num) + 1;
        }

        private void init(int length) {
            c = new int[length];
            Arrays.fill(c, 0);
        }

        private void discretization(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int size = set.size();
            a = new int[size];
            int index = 0;
            for (Integer num : set) {
                a[index++] = num;
            }
            Arrays.sort(a);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}