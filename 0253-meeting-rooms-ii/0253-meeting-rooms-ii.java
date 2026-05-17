class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.add(intervals[0]);
        int result = 1;

        for(int i=1; i<intervals.length;i++){
            if(pq.isEmpty()){
                pq.add(intervals[i]);
                continue;
            }
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            while(!pq.isEmpty() && pq.peek()[1] <= startTime){
                pq.poll();
            }

            pq.add(intervals[i]);
            result = Math.max(result, pq.size());
            
        }

        return result;

    }
}