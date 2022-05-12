//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 
// 👍 412 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        solution.combinationSum3(3, 9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            combinationSum3(res, new ArrayList<Integer>(), k, n, 0, 0, 1);
            return res;
        }

        private void combinationSum3(List<List<Integer>> res, ArrayList<Integer> list, int k, int n, int num, int sum, int index) {
            if (k == num && n == sum) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (k == num) return;
            if (sum >= n) return;
            for (int i = index; i < 10; i++) {
                list.add(i);
                combinationSum3(res, list, k, n, num + 1, sum + i, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
