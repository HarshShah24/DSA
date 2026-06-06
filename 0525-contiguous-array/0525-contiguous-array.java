class Solution {
    public int findMaxLength(int[] nums) {
        
    

        final Map<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int result = 0;
        int target = 0;

        map.put(0,-1);

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(prefixSum-target)){
                int len = i - map.get(prefixSum-target);
                result =  Math.max(result,len);
            }
            else{
                map.put(prefixSum,i);
            }
            
        }

        return result;

    }
}