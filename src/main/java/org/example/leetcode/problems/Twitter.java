package org.example.leetcode.problems;


import java.util.*;

/**
 * @Description 设计推特    https://leetcode-cn.com/problems/design-twitter/
 * 思路：哈希表 + 链表
 * @Author Marcoo
 * @Date 2020/4/13 19:36
 */
public class Twitter {
    public static void main(String[] args) throws InterruptedException {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
//        System.out.println(twitter.getNewsFeed(1));

//        twitter.follow(1, 3);
//        System.out.println(twitter.getNewsFeed(2));

//        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(1));
    }

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User user = userMap.get(userId);
        if (user == null) {
            user = new User();
            userMap.put(userId, user);
        }
        Tweet tweet = new Tweet(tweetId, ++GLOBAL_TIME);
        user.tweets.add(tweet);
    }

    public List<Integer>  getNewsFeed(int userId) {
        User user = userMap.get(userId);
        if (user == null) {
            return new ArrayList<>();
        }

        TreeSet<Tweet> set = new TreeSet<>();
        for (int followeeId : user.followeeSet) {
            User followee = userMap.get(followeeId);
            if (followee != null) {
                addRecentTenTweet(set, followee.tweets);
            }
        }
        addRecentTenTweet(set, user.tweets);
        int count = 0;
        List<Integer> newsFeed = new ArrayList<>();
        for (Tweet tweet : set) {
            count++;
            if (count > 10) {
                break;
            }
            newsFeed.add(tweet.tweetId);
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if (user == null) {
            user = new User();
            userMap.put(followerId, user);
        }
        user.followeeSet.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if (user == null) {
            user = new User();
            userMap.put(followerId, user);
        }
        user.followeeSet.remove(followeeId);
    }

    private void addRecentTenTweet(TreeSet<Tweet> set, List<Tweet> tweets) {
        for (int i = tweets.size() - 1; i >= 0 && i >= tweets.size() - 10 ; i--) {
            set.add(tweets.get(i));
        }
    }

    private static int GLOBAL_TIME = 0;

    private Map<Integer, User> userMap;

    public static class User {
        Set<Integer> followeeSet = new HashSet<>();
        List<Tweet> tweets = new ArrayList<>();
    }

    public static class Tweet implements Comparable<Tweet>{
        int tweetId;
        int postTime;

        public Tweet(int tweetId, int postTime) {
            this.tweetId = tweetId;
            this.postTime = postTime;
        }

        @Override
        public int compareTo(Tweet o) {
            return o.postTime - postTime;
        }
    }
}
