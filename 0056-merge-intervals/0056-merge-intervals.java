class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals , (a , b) -> Integer.compare(a[0], b[0]));

        final List<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];

        for(int i=1; i<intervals.length; i++){
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            if(startTime <= prevInterval[1]){ //Current Interval Start < Prev Interval End
                prevInterval[1] = Math.max(endTime,prevInterval[1]);
            }else{
                result.add(prevInterval);
                prevInterval = intervals[i];
            }
        }

        result.add(prevInterval);

        

        return result.stream().toArray(int[][]::new);

    }
}