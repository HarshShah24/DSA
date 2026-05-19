class RecentCounter {
    TreeMap<Integer,Integer> map;
    public RecentCounter() {
        map = new TreeMap<>();
    }
    
    public int ping(int t) {
        map.put(t,map.getOrDefault(t,0)+1);
        return map.tailMap(t-3000,true).values().stream().collect(Collectors.summingInt(Integer::intValue));
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */