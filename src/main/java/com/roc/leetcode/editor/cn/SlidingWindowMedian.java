//中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 
//窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
// Related Topics 数组 哈希表 滑动窗口 堆（优先队列） 👍 382 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMedian().new Solution();
        solution.medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            double[] res = new double[n - k + 1];
            int size = k / 2;
            PriorityQueue<Long> left = new PriorityQueue<>(Math.max(1, size), (o1, o2) -> Long.compare(o2, o1));
            PriorityQueue<Long> right = new PriorityQueue<>(Math.max(1, size), (o1, o2) -> Long.compare(o1, o2));
            // 初始化
            for (int i = 0; i < k; i++) {
                right.add((long) nums[i]);
            }
            for (int i = 0; i < size; i++) {
                left.add(right.poll());
            }
            if (left.size() < right.size()) {
                res[0] = right.peek();
            } else {
                res[0] = (left.peek() / 2.0) + (right.peek() / 2.0);
            }
            for (int i = 1; i <= n - k; i++) {
                if (right.peek() <= nums[i - 1]) {
                    right.remove((long) nums[i - 1]);
                    if (!left.isEmpty()) {
                        right.add(left.poll());
                    }
                } else {
                    left.remove((long) nums[i - 1]);
                }
                right.add((long) nums[i + k - 1]);
                if (right.size() > 1) {
                    left.add(right.poll());
                }
                if (left.size() < right.size()) {
                    res[i] = right.peek();
                } else {
                    res[i] = (left.peek() / 2.0) + (right.peek() / 2.0);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}