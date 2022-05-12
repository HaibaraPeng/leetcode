//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 591 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(9, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String getPermutation(int n, int k) {
            int[] factorial = new int[n];
            factorial[0] = 1;
            for (int i = 1; i < n; ++i) {
                factorial[i] = factorial[i - 1] * i;
            }

            --k;
            StringBuffer ans = new StringBuffer();
            int[] valid = new int[n + 1];
            Arrays.fill(valid, 1);
            for (int i = 1; i <= n; ++i) {
                int order = k / factorial[n - i] + 1;
                for (int j = 1; j <= n; ++j) {
                    order -= valid[j];
                    if (order == 0) {
                        ans.append(j);
                        valid[j] = 0;
                        break;
                    }
                }
                k %= factorial[n - i];
            }
            return ans.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    // ----------递归-----------
//    private int limit;
//
//    public String getPermutation(int n, int k) {
//        List<String> list = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        limit = k;
//        permutation(list, set, new StringBuilder(), n, 0);
//        return list.get(k - 1);
//    }
//
//    private void permutation(List<String> list, Set<Integer> set, StringBuilder stringBuilder, int n, int index) {
//        if (index == n) {
//            list.add(stringBuilder.toString());
//            limit--;
//            return;
//        }
//        if (limit == 0) return;
//        for (int i = 1; i < n + 1; i++) {
//            if (!set.contains(i)) {
//                set.add(i);
//                stringBuilder.append(i);
//                permutation(list, set, stringBuilder, n, index + 1);
//                set.remove(i);
//                stringBuilder.deleteCharAt(index);
//            }
//        }
//    }

}
