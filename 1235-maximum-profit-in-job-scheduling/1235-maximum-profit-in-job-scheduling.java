class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        final int[][] jobs = new int[startTime.length][3];

        for(int i=0; i<startTime.length;i++){
            jobs[i][0] =  startTime[i];
            jobs[i][1] =  endTime[i];
            jobs[i][2] =  profit[i];
        }

        int maxProfit = 0;

        Arrays.sort(jobs, (a ,b) -> Integer.compare(a[1], b[1])); //Sort by end time
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(0,0);

        for(int[] job : jobs){
            int start = job[0];
            int end = job[1];
            int prof = job[2];

            int prevMaxProfit = treeMap.floorEntry(start).getValue(); //Prev non overlapping / disconnected interval
            int currentProfit = prevMaxProfit + prof;
            
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
                treeMap.put(end,maxProfit);
            }
        }


        return maxProfit;

    }
}