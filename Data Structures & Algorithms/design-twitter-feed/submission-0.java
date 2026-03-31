class Twitter {
    private static int timestamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet {
        int id;
        int time;
        Tweet next; // Pointer to the next tweet in the user's list

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead; // Head of the user's linked list of tweets

        User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // Follow self
            tweetHead = null;
        }

        void follow(int id) { followed.add(id); }
        void unfollow(int id) { if (id != this.id) followed.remove(id); }
        void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        // PriorityQueue to merge multiple sorted lists
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        for (int id : users) {
            Tweet t = userMap.get(id).tweetHead;
            if (t != null) pq.add(t);
        }

        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if (t.next != null) pq.add(t.next);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}