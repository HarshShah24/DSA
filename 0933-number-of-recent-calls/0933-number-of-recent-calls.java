class RecentCounter {

    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        int startTime =  t - 3000;
        // Evict outdated timestamps from the front of the queue
        while (!queue.isEmpty() && queue.peek() < startTime) {
            queue.poll();
        }
        queue.add(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */