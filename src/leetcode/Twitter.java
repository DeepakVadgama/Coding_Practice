package leetcode;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Twitter {

    private Map<Integer, LinkedList<Tweet>> tweets;
    private Map<Integer, Set<Integer>> followers;
    private static final int MAX = 10;

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        tweets.get(userId).addFirst(new Tweet(tweetId, LocalDateTime.now()));
        LinkedList<Tweet> userTweets = tweets.get(userId);
        if (userTweets.size() > MAX) {
            userTweets.removeLast();
        }
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Tweet> result = new ArrayList<>();
        Set<Integer> followees = followers.get(userId);
        if (followees != null && !followees.isEmpty()) {
            // Too much garbage possible at scale
            // Better is to iterate horizontally all lists, based on timestamps.
            for (Integer followee : followees) {
                if (tweets.containsKey(followee)) {
                    result.addAll(tweets.get(followee));
                }
            }
        }

        if (tweets.containsKey(userId)) {
            result.addAll(tweets.get(userId));
        }

        Collections.sort(result);
        return result.stream().limit(MAX).map(tweet -> tweet.id).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    private class Tweet implements Comparable {

        public int id;
        public LocalDateTime time;

        public Tweet(int id, LocalDateTime time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Object o) {
            return ((Tweet) o).time.compareTo(time);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
    }
}
