//一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。 
//
// 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。开始时， 青蛙默认已站在第一
//块石子上，并可以假定它第一步只能跳跃 1 个单位（即只能从单元格 1 跳至单元格 2 ）。 
//
// 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [0,1,3,5,6,8,12,17]
//输出：true
//解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然
//后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。 
//
// 示例 2： 
//
// 
//输入：stones = [0,1,2,3,4,8,9,11]
//输出：false
//解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。 
//
// 
//
// 提示： 
//
// 
// 2 <= stones.length <= 2000 
// 0 <= stones[i] <= 2³¹ - 1 
// stones[0] == 0 
// stones 按严格升序排列 
// 
// Related Topics 数组 动态规划 👍 457 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public static void main(String[] args) {
        Solution solution = new FrogJump().new Solution();
        solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canCross(int[] stones) {
            int n = stones.length;
            Map<Integer, Integer> stoneMap = new HashMap<>(8);
            Map<String, Boolean> cache = new HashMap<>(8);
            for (int i = 0; i < n; i++) {
                stoneMap.put(stones[i], i);
            }
            // 第一步
            if (!stoneMap.containsKey(1)) {
                return false;
            }
            return dfs(stoneMap, cache, n - 1, 1, 1);
        }

        private boolean dfs(Map<Integer, Integer> stoneMap, Map<String, Boolean> cache, int target, int cur, int step) {
            String key = cur + "_" + step;
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            if (target == stoneMap.get(cur)) {
                return true;
            }
            for (int i = step - 1; i <= step + 1; i++) {
                if (i <= 0) {
                    continue;
                }
                int next = cur + i;
                if (stoneMap.containsKey(next)) {
                    boolean res = dfs(stoneMap, cache, target, next, i);
                    if (res) {
                        return true;
                    }
                }
            }
            cache.put(key, false);
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}