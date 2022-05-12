//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1654 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Deque<Integer> monoStack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }
                left[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
                monoStack.push(i);
            }
            monoStack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }
                right[i] = monoStack.isEmpty() ? n : monoStack.peek();
                monoStack.push(i);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
