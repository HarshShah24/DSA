class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());

        // 1. Initialize the first window (first k-1 elements)
        for (int i = 0; i < k - 1; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }

        // 2. Slide the window across the rest of the array
        for (int i = k - 1; i < nums.length; i++) {
            // Add the new element entering the window
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);

            // The largest element is now at the top of our reversed TreeMap
            result[resultIndex++] = treeMap.firstKey();

            // Remove the element that is leaving the window (nums[i - k + 1])
            int elementToRemove = nums[i - k + 1];
            int count = treeMap.get(elementToRemove);
            if (count > 1) {
                treeMap.put(elementToRemove, count - 1); // Fixed typo here
            } else {
                treeMap.remove(elementToRemove);
            }
        }

        return result;
    }
}