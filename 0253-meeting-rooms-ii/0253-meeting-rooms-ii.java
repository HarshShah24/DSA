class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]);
        int result = 1;

        for(int i=1; i<intervals.length;i++){
            if(pq.isEmpty()){
                pq.add(intervals[i][1]);
                continue;
            }
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            if(!pq.isEmpty() && pq.peek() <= startTime){
                pq.poll();
            }

            pq.add(intervals[i][1]);
            result = Math.max(result, pq.size());
            
        }

        return result;

    }
}