//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
// Related Topics 数组 二分查找 动态规划 排序 👍 798 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        int[][] envelopes = new int[][]{
                {15, 8},
                {2, 20},
                {2, 14},
                {4, 17},
                {8, 19},
                {8, 9},
                {5, 7},
                {11, 19},
                {8, 11},
                {13, 11},
                {2, 13},
                {11, 19},
                {8, 11},
                {13, 11},
                {2, 13},
                {11, 19},
                {16, 1},
                {18, 13},
                {14, 17},
                {18, 19},
        };
        solution.maxEnvelopes(envelopes);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            int n = envelopes.length;
            int[] dp = new int[n];
            dp[0] = 1;
            PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[0] - o1[0]));
            queue.add(new int[]{1, 0});
            for (int i = 1; i < n; i++) {
                List<int[]> temp = new ArrayList<>();
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    temp.add(poll);
                    if (envelopes[i][0] > envelopes[poll[1]][0] && envelopes[i][1] > envelopes[poll[1]][1]) {
                        dp[i] = poll[0] + 1;
                        break;
                    }
                    dp[i] = 1;
                }
                temp.add(new int[]{dp[i], i});
                queue.addAll(temp);
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}