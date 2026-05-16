class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int leftCount = 0;
        int rigtCount = 0;
        int blankCount = 0;

        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                leftCount++;
            }else if(ch == 'R'){
                rigtCount++;
            }else{
                blankCount++;
            }
        }

        int sum = blankCount + Math.max(leftCount,rigtCount) - Math.min(leftCount,rigtCount);
        return sum;
    }
}