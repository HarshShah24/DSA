class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        boolean isReplacementUsed = false;
        int startWindow = 0;
        int nextWindowStart = -1;
        int maxWindow = 0;
        
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                if (!isReplacementUsed) {
                    isReplacementUsed = true;
                    nextWindowStart = index;
                } else {
                    // The old zero at nextWindowStart drops out
                    startWindow = nextWindowStart + 1;
                    // The current zero at 'index' becomes the newly flipped zero
                    nextWindowStart = index; 
                    // isReplacementUsed STAYS true because 'index' is a zero!
                }
            }
            maxWindow = Math.max(index - startWindow + 1, maxWindow);
            index++;
        }
        
        return maxWindow;
    }
}
