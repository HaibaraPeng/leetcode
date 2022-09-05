//设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。 
//
// 实现 TimeMap 类： 
//
// 
// TimeMap() 初始化数据结构对象 
// void set(String key, String value, int timestamp) 存储键 key、值 value，以及给定的时间戳 
//timestamp。 
// String get(String key, int timestamp)
// 
// 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp 。
// 
// 如果有多个这样的值，则返回对应最大的 timestamp_prev 的那个值。 
// 如果没有值，则返回空字符串（""）。 
// 
// 
// 
// 
//
// 示例： 
//
// 
//输入：
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
//, ["foo", 5]]
//输出：
//[null, null, "bar", "bar", null, "bar2", "bar2"]
//
//解释：
//TimeMap timeMap = new TimeMap();
//timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1   
//timeMap.get("foo", 1);         // 返回 "bar"
//timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯
//一的值位于时间戳 1 处（即 "bar"） 。
//timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4  
//timeMap.get("foo", 4);         // 返回 "bar2"
//timeMap.get("foo", 5);         // 返回 "bar2"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, value.length <= 100 
// key 和 value 由小写英文字母和数字组成 
// 1 <= timestamp <= 10⁷ 
// set 操作中的时间戳 timestamp 都是严格递增的 
// 最多调用 set 和 get 操作 2 * 10⁵ 次 
// 
// Related Topics 设计 哈希表 字符串 二分查找 👍 180 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
//        TimeMap map = new TimeMap();
//        map.set("foo", "bar", 1);
//        map.get("foo", 1);
//        map.get("foo", 3);
//        map.set("foo", "bar2", 4);
//        map.get("foo", 4);
//        map.get("foo", 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class TimeMap {

        Map<String, List<Value>> map;

        class Value {
            String value;
            int timestamp;

            public Value(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        public TimeMap() {
            map = new HashMap<>(8);
        }

        public void set(String key, String value, int timestamp) {
            List<Value> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(new Value(value, timestamp));
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            List<Value> list = map.get(key);
            if (list.get(0).timestamp > timestamp) {
                return "";
            }
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left);
                Value value = list.get(mid);
                if (value.timestamp == timestamp) {
                    return value.value;
                } else if (value.timestamp > timestamp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return list.get(right).value;
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

}