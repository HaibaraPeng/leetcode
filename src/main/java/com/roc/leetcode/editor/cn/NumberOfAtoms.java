//给你一个字符串化学式 formula ，返回 每种原子的数量 。 
//
// 原子总是以一个大写字母开始，接着跟随 0 个或任意个小写字母，表示原子的名字。 
//
// 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。 
//
// 
// 例如，"H2O" 和 "H2O2" 是可行的，但 "H1O2" 这个表达是不可行的。 
// 
//
// 两个化学式连在一起可以构成新的化学式。 
//
// 
// 例如 "H2O2He3Mg4" 也是化学式。 
// 
//
// 由括号括起的化学式并佐以数字（可选择性添加）也是化学式。 
//
// 
// 例如 "(H2O2)" 和 "(H2O2)3" 是化学式。 
// 
//
// 返回所有原子的数量，格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于
// 1），以此类推。 
//
// 
//
// 示例 1： 
//
// 
//输入：formula = "H2O"
//输出："H2O"
//解释：原子的数量是 {'H': 2, 'O': 1}。
// 
//
// 示例 2： 
//
// 
//输入：formula = "Mg(OH)2"
//输出："H2MgO2"
//解释：原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
// 
//
// 示例 3： 
//
// 
//输入：formula = "K4(ON(SO3)2)2"
//输出："K4N2O14S4"
//解释：原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= formula.length <= 1000 
// formula 由英文字母、数字、'(' 和 ')' 组成 
// formula 总是有效的化学式 
// 
// Related Topics 栈 哈希表 字符串 排序 👍 259 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class NumberOfAtoms {
    public static void main(String[] args) {
        Solution solution = new NumberOfAtoms().new Solution();
        solution.countOfAtoms("K4(ON(SO3)2)2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Node {
            String s;
            Integer v;

            Node(String _s, Integer _v) {
                s = _s;
                v = _v;
            }
        }

        public String countOfAtoms(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            Map<String, Integer> map = new HashMap<>();
            Deque<String> d = new ArrayDeque<>();
            int idx = 0;
            for (int i = 0; i < n; ) {
                char c = cs[i];
                if (c == '(' || c == ')') {
                    d.addLast(String.valueOf(c));
                    i++;
                } else {
                    if (Character.isDigit(c)) {
                        // 获取完整的数字，并解析出对应的数值
                        int j = i;
                        while (j < n && Character.isDigit(cs[j])) j++;
                        String numStr = s.substring(i, j);
                        i = j;
                        int cnt = Integer.parseInt(String.valueOf(numStr));
                        // 如果栈顶元素是 )，说明当前数值可以应用给「连续一段」的原子中
                        if (!d.isEmpty() && d.peekLast().equals(")")) {
                            List<String> tmp = new ArrayList<>();
                            d.pollLast(); // pop )
                            while (!d.isEmpty() && !d.peekLast().equals("(")) {
                                String cur = d.pollLast();
                                map.put(cur, map.getOrDefault(cur, 1) * cnt);
                                tmp.add(cur);
                            }
                            d.pollLast(); // pop (
                            for (int k = tmp.size() - 1; k >= 0; k--) {
                                d.addLast(tmp.get(k));
                            }
                            // 如果栈顶元素不是 )，说明当前数值只能应用给栈顶的原子
                        } else {
                            String cur = d.pollLast();
                            map.put(cur, map.getOrDefault(cur, 1) * cnt);
                            d.addLast(cur);
                        }
                    } else {
                        // 获取完整的原子名
                        int j = i + 1;
                        while (j < n && Character.isLowerCase(cs[j])) j++;
                        String cur = s.substring(i, j) + "_" + String.valueOf(idx++);
                        map.put(cur, map.getOrDefault(cur, 0) + 1);
                        i = j;
                        d.addLast(cur);
                    }
                }
            }
// 将不同编号的相同原子进行合并
            Map<String, Node> mm = new HashMap<>();
            for (String key : map.keySet()) {
                String atom = key.split("_")[0];
                int cnt = map.get(key);
                Node node = null;
                if (mm.containsKey(atom)) {
                    node = mm.get(atom);
                } else {
                    node = new Node(atom, 0);
                }
                node.v += cnt;
                mm.put(atom, node);
            }
// 使用优先队列（堆）对 Node 进行字典序排序，并构造答案
            PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> a.s.compareTo(b.s));
            for (String atom : mm.keySet()) q.add(mm.get(atom));
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                Node poll = q.poll();
                sb.append(poll.s);
                if (poll.v > 1) sb.append(poll.v);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//    class Solution {
//        class Node {
//            String s;
//            Integer v;
//
//            Node(String _s, Integer _v) {
//                s = _s;
//                v = _v;
//            }
//        }
//
//        public String countOfAtoms(String formula) {
//            int len = formula.length();
//            Map<String, Integer> map = countOfAtoms(formula, 1, 0, len);
//
//            // 使用优先队列（堆）对 Node 进行字典序排序，并构造答案
//            PriorityQueue<Node> q = new PriorityQueue<Node>(Comparator.comparing(a -> a.s));
//            for (String atom : map.keySet()) {
//                q.add(new Node(atom, map.get(atom)));
//            }
//            StringBuilder sb = new StringBuilder();
//            while (!q.isEmpty()) {
//                Node poll = q.poll();
//                sb.append(poll.s);
//                if (poll.v > 1) {
//                    sb.append(poll.v);
//                }
//            }
//            return sb.toString();
//        }
//
//        private Map<String, Integer> countOfAtoms(String formula, int mul, int left, int right) {
//            Map<String, Integer> map = new HashMap<>(8);
//            String key = null;
//            for (int i = left; i < right; ) {
//                if (Character.isUpperCase(formula.charAt(i))) {
//                    if (key != null) {
//                        map.put(key, map.getOrDefault(key, 0) + 1);
//                    }
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(formula.charAt(i++));
//                    // 获取小写字母
//                    while (i < right && Character.isLowerCase(formula.charAt(i))) {
//                        sb.append(formula.charAt(i++));
//                    }
//                    key = sb.toString();
//                } else if (Character.isDigit(formula.charAt(i))) {
//                    // 获取数字
//                    int num = formula.charAt(i++) - '0';
//                    while (i < right && Character.isDigit(formula.charAt(i))) {
//                        num = num * 10 + (formula.charAt(i++) - '0');
//                    }
//                    map.put(key, map.getOrDefault(key, 0) + num);
//                    key = null;
//                } else if (formula.charAt(i) == '(') {
//                    if (key != null) {
//                        map.put(key, map.getOrDefault(key, 0) + 1);
//                    }
//                    key = null;
//                    int l = i + 1;
//                    // 获取right左边的第一个右括号
//                    int index = right - 1;
//                    while (formula.charAt(index) != ')') {
//                        index--;
//                    }
//                    int r = index;
//                    // 获取倍数
//                    int m = 0;
//                    index++;
//                    if (index == right) {
//                        m = 1;
//                    } else {
//                        while (index < right && Character.isDigit(formula.charAt(index))) {
//                            m = m * 10 + (formula.charAt(index++) - '0');
//                        }
//                    }
//                    Map<String, Integer> subMap = countOfAtoms(formula, m, l, r);
//                    for (String s : subMap.keySet()) {
//                        map.put(s, map.getOrDefault(s, 0) + subMap.get(s));
//                    }
//                    i = index;
//                }
//            }
//            if (key != null) {
//                map.put(key, map.getOrDefault(key, 0) + 1);
//            }
//            for (String s : map.keySet()) {
//                map.put(s, map.get(s) * mul);
//            }
//            return map;
//        }
//    }

}