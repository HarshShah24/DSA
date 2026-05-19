class Solution {
    public int firstUniqChar(String s) {
        final int[] freqCount = new int[26];

        for(char ch : s.toCharArray()){
            freqCount[ch - 'a']++;
        }

        for(int i=0; i<s.length();i++){
            if(freqCount[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}