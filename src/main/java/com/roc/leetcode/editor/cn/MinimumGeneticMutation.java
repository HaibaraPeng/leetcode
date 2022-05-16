//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。 
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。 
//
// 
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 
// 
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。 
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。 
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：start = "AAAA ACCC", end = "AACC CCCC", bank = ["AAAA CCCC","AAAC CCCC",
//"AACC CCCC"]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 209 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
        solution.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC",
                "AACCCCCC"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> bankSet = new HashSet<>();
            Set<String> visitedSet = new HashSet<>();
            List<Character> geneticList = new ArrayList<>();
            geneticList.add('A');
            geneticList.add('C');
            geneticList.add('T');
            geneticList.add('G');
            for (int i = 0; i < bank.length; i++) {
                bankSet.add(bank[i]);
            }
            if (!bankSet.contains(end)) {
                return -1;
            }
            if (start.equals(end)) {
                return 0;
            }
            int res = 1;
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();
                    for (int j = 0; j < poll.length(); j++) {
                        for (int k = 0; k < geneticList.size(); k++) {
                            if (poll.charAt(j) != geneticList.get(k)) {
                                StringBuilder sb = new StringBuilder(poll);
                                sb.setCharAt(j, geneticList.get(k));
                                String temp = sb.toString();
                                if (temp.equals(end)) {
                                    return res;
                                }
                                if (!visitedSet.contains(temp) && bankSet.contains(temp)) {
                                    visitedSet.add(temp);
                                    queue.add(temp);
                                }
                            }
                        }
                    }
                }
                res++;
            }
            return -1;
        }

//        public int minMutation(String start, String end, String[] bank) {
//            Set<String> cnt = new HashSet<>();
//            Set<String> visited = new HashSet<>();
//            char[] keys = {'A', 'C', 'G', 'T'};
//            for (String w : bank) {
//                cnt.add(w);
//            }
//            if (start.equals(end)) {
//                return 0;
//            }
//            if (!cnt.contains(end)) {
//                return -1;
//            }
//            Queue<String> queue = new ArrayDeque<>();
//            queue.offer(start);
//            visited.add(start);
//            int step = 1;
//            while (!queue.isEmpty()) {
//                int sz = queue.size();
//                for (int i = 0; i < sz; i++) {
//                    String curr = queue.poll();
//                    for (int j = 0; j < 8; j++) {
//                        for (int k = 0; k < 4; k++) {
//                            if (keys[k] != curr.charAt(j)) {
//                                StringBuffer sb = new StringBuffer(curr);
//                                sb.setCharAt(j, keys[k]);
//                                String next = sb.toString();
//                                if (!visited.contains(next) && cnt.contains(next)) {
//                                    if (next.equals(end)) {
//                                        return step;
//                                    }
//                                    queue.offer(next);
//                                    visited.add(next);
//                                }
//                            }
//                        }
//                    }
//                }
//                step++;
//            }
//            return -1;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}