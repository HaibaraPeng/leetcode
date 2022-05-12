//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。 
//
// 实现 Twitter 类： 
//
// 
// Twitter() 初始化简易版推特对象 
// void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函
//数都会使用一个不同的 tweetId 。 
// List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近 10 条推文的 ID 。新闻推送中的每一项都必须是
//由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。 
// void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 foll
//oweeId 的用户。 
// void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 fo
//lloweeId 的用户。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", 
//"unfollow", "getNewsFeed"]
//[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//输出
//[null, null, [5], null, null, [6, 5], null, [5]]
//
//解释
//Twitter twitter = new Twitter();
//twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
//twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
//twitter.follow(1, 2);    // 用户 1 关注了用户 2
//twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
//twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 i
//d 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
//twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
//twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用
//户 2 
//
// 
//
// 提示： 
//
// 
// 1 <= userId, followerId, followeeId <= 500 
// 0 <= tweetId <= 104 
// 所有推特的 ID 都互不相同 
// postTweet、getNewsFeed、follow 和 unfollow 方法最多调用 3 * 104 次 
// 
// Related Topics 设计 哈希表 链表 堆（优先队列） 
// 👍 292 👎 0

/**
 * @author dongp
 */
package com.roc.leetcode.editor.cn;

import java.util.*;

public class DesignTwitter {
    public static void main(String[] args) {
//        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 1); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
//        twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
//        twitter.follow(2, 1);    // 用户 1 关注了用户 2
//        twitter.getNewsFeed(2); // 用户 2 发送了一个新推文 (推文 id = 6)
//        twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
//        twitter.unfollow(2, 1);  // 用户 1 取消关注了用户 2
//        twitter.getNewsFeed(2);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {

        private class Node {
            // 哈希表存储关注人的 Id
            Set<Integer> followee;
            // 用链表存储 tweetId
            LinkedList<Integer> tweet;

            Node() {
                followee = new HashSet<Integer>();
                tweet = new LinkedList<Integer>();
            }
        }

        // getNewsFeed 检索的推文的上限以及 tweetId 的时间戳
        private int recentMax, time;
        // tweetId 对应发送的时间
        private Map<Integer, Integer> tweetTime;
        // 每个用户存储的信息
        private Map<Integer, Node> user;

        public Twitter() {
            time = 0;
            recentMax = 10;
            tweetTime = new HashMap<Integer, Integer>();
            user = new HashMap<Integer, Node>();
        }

        // 初始化
        public void init(int userId) {
            user.put(userId, new Node());
        }

        public void postTweet(int userId, int tweetId) {
            if (!user.containsKey(userId)) {
                init(userId);
            }
            // 达到限制，剔除链表末尾元素
            if (user.get(userId).tweet.size() == recentMax) {
                user.get(userId).tweet.remove(recentMax - 1);
            }
            user.get(userId).tweet.addFirst(tweetId);
            tweetTime.put(tweetId, ++time);
        }

        public List<Integer> getNewsFeed(int userId) {
            LinkedList<Integer> ans = new LinkedList<Integer>();
            for (int it : user.getOrDefault(userId, new Node()).tweet) {
                ans.addLast(it);
            }
            for (int followeeId : user.getOrDefault(userId, new Node()).followee) {
                if (followeeId == userId) { // 可能出现自己关注自己的情况
                    continue;
                }
                LinkedList<Integer> res = new LinkedList<Integer>();
                int tweetSize = user.get(followeeId).tweet.size();
                Iterator<Integer> it = user.get(followeeId).tweet.iterator();
                int i = 0;
                int j = 0;
                int curr = -1;
                // 线性归并
                if (j < tweetSize) {
                    curr = it.next();
                    while (i < ans.size() && j < tweetSize) {
                        if (tweetTime.get(curr) > tweetTime.get(ans.get(i))) {
                            res.addLast(curr);
                            ++j;
                            if (it.hasNext()) {
                                curr = it.next();
                            }
                        } else {
                            res.addLast(ans.get(i));
                            ++i;
                        }
                        // 已经找到这两个链表合起来后最近的 recentMax 条推文
                        if (res.size() == recentMax) {
                            break;
                        }
                    }
                }
                for (; i < ans.size() && res.size() < recentMax; ++i) {
                    res.addLast(ans.get(i));
                }
                if (j < tweetSize && res.size() < recentMax) {
                    res.addLast(curr);
                    for (; it.hasNext() && res.size() < recentMax; ) {
                        res.addLast(it.next());
                    }
                }
                ans = new LinkedList<Integer>(res);
            }
            return ans;
        }

        public void follow(int followerId, int followeeId) {
            if (!user.containsKey(followerId)) {
                init(followerId);
            }
            if (!user.containsKey(followeeId)) {
                init(followeeId);
            }
            user.get(followerId).followee.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            user.getOrDefault(followerId, new Node()).followee.remove(followeeId);
        }
    }


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}