class Solution {
    public int largestRectangleArea(int[] heights) {
        final Deque<int[]> stack = new ArrayDeque<>();

        int result = 0;

        for(int i=0; i<heights.length;i++){

            int barHeight = heights[i];
            if(stack.isEmpty()){
                stack.push(new int[]{i,barHeight});
            }else{
                while(!stack.isEmpty() && stack.peek()[1] >= barHeight){
                    int[] pair = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek()[0] - 1;
                    int area = width * pair[1];
                    result = Math.max(area,result);
                }
                stack.push(new int[]{i,barHeight});
            }

        }

        while(!stack.isEmpty()){
            int[] pair = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek()[0] - 1;
            int area = width * pair[1];
            result = Math.max(area,result);
        }


        return result;

    }
}