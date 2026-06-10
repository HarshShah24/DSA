class RecentCounter {

    PriorityQueue<Integer> pq;

    public RecentCounter() {
        pq = new PriorityQueue<>();
    }
    
    public int ping(int t) {
        int startTime =  t - 3000;
        while(!pq.isEmpty() && pq.peek() < startTime){
            pq.poll();
        }
        pq.add(t);
        return pq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */