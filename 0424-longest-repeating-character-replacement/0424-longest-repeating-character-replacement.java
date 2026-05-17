class Solution {
    public int characterReplacement(String s, int k) {
        
        final Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            int windowSize = right - left + 1;
            int maxFreq = findMax(map);

            if(windowSize - maxFreq > k){
               
                char removeChar = s.charAt(left);
                map.put(removeChar,map.get(removeChar)-1);
                if(map.get(removeChar) <= 0){
                    map.remove(removeChar);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);

        }

        return result;



    }

    public int findMax(Map<Character, Integer> map){
        int max = 0;
        for(char key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
        return max;
    }
}