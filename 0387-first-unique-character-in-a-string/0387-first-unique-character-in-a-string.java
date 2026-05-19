class Solution {
    public int firstUniqChar(String s) {
        
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.remove(ch);
                set.add(ch);
            }else{
                if(!set.contains(ch)){
                    map.put(ch,i);
                }
            }

        }

        return map.keySet().isEmpty() ? -1 : map.get(map.keySet().iterator().next());

    }
}