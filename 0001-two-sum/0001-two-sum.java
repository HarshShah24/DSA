class Solution {
    public int[] twoSum(int[] nums, int target) {
        

        int[][] arry = new int[nums.length][2];

        for(int i=0; i<nums.length; i++){
            arry[i] = new int[]{nums[i], i};
        }

        Arrays.sort(arry, (a ,b) -> Integer.compare(a[0], b[0]));


        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int sum = arry[left][0] + arry[right][0];
            if(sum == target){
                return new int[]{arry[left][1], arry[right][1]};
            }else if( sum > target ){
                right--;
            }else{
                left++;
            }
        }

        return new int[]{-1,-1};
    }
}