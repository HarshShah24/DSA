class Solution {

    int maxLength = 0;
    int maxLeft = 0;
    int maxRight = 0;

    public String longestPalindrome(String s) {


        if(s == null || s.length() <= 1){
            return s;
        }
        

        for(int i=0; i<s.length(); i++){
           longestPalindrome(i,i,s);
           longestPalindrome(i,i+1,s);
        }

        return s.substring(maxLeft+1,maxRight);
        
    }

    public void longestPalindrome(int left, int right, String str){
        
        while(left >= 0 && right < str.length()){
            if(str.charAt(left) == str.charAt(right)){
                left--;
                right++;
            }
            else{
                break;
            }
        }

       int currentLength = right - left - 1;

        if(maxLength < currentLength){
            maxLength = currentLength;
            maxLeft = left;
            maxRight = right;
        }
       
    }
}