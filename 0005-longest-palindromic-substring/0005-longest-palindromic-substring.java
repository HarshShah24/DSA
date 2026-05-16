class Solution {
    public String longestPalindrome(String s) {


        if(s == null || s.length() == 1){
            return s;
        }
        
        String result = "";

        for(int i=0; i<s.length(); i++){
            String p1 = longestPalindrome(i,i,s);
            String p2 = longestPalindrome(i,i+1,s);
            if(p1.length() > result.length() || p2.length() > result.length()){
                result = p1.length() > p2.length() ? p1 : p2;
            }
        }

        return result;
        
    }

    public String longestPalindrome(int left, int right, String str){
        
        while(left >= 0 && right < str.length()){
            if(str.charAt(left) == str.charAt(right)){
                left--;
                right++;
            }
            else{
                break;
            }
        }

        return str.substring(left+1, right);
    }
}