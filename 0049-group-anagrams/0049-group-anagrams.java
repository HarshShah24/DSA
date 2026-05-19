class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        final Map<FrequencyChar, List<String>> map = new HashMap<>();

        for (String str : strs) {
            FrequencyChar freqChar = new FrequencyChar(str);
            map.computeIfAbsent(freqChar, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        return map.values().stream().collect(Collectors.toList());
    }

}

class FrequencyChar {

    char[] charArry = new char[26];
    int hash;

    public FrequencyChar(String str) {

        for (int i = 0; i < str.length(); i++) {
            charArry[str.charAt(i) - 'a']++;
            hash += str.charAt(i);
        }

    }

    @Override
    public int hashCode() {
        return this.hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof FrequencyChar))
            return false;

        return Arrays.equals(this.charArry, ((FrequencyChar) obj).charArry);
    }

}