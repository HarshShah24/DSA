class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        final Map<Character,List<Integer>> charIndexMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            charIndexMap.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        char ch = goal.charAt(0);

        if(!charIndexMap.containsKey(ch)){
            return false;
        }

        for(int index : charIndexMap.get(ch)){
            String preString = s.substring(0,index);
            String postString = s.substring(index);
            if((postString + preString).equals(goal)){
                return true;
            }
        }

        return false;
    }
}