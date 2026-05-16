class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        final Map<Character,Integer> map = new HashMap<>();

        for(char ch : moves.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int maxCharacter = map.getOrDefault('L',0) >  map.getOrDefault('R',0) ? map.getOrDefault('L',0) : map.getOrDefault('R',0);
        int minCharacter = map.getOrDefault('L',0) <  map.getOrDefault('R',0) ?  map.getOrDefault('L',0) : map.getOrDefault('R',0);

        int sum = map.getOrDefault('_',0) + maxCharacter - minCharacter;
        return sum;
    }
}