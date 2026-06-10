class Solution {
    public String decodeString(String s) {
        
        final ArrayDeque<Integer> countStack = new ArrayDeque<>();
        final ArrayDeque<StringBuilder> seqStack = new ArrayDeque<>();

        StringBuilder current = new StringBuilder();
        int count = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                count = count*10 + (ch - '0');
            }else if(Character.isAlphabetic(ch)){
                current.append(ch);
            }else if(ch == '['){
                seqStack.push(current);
                countStack.push(count);
                current = new StringBuilder();
                count = 0;
            }else {
                int repeat = countStack.pop();
                StringBuilder decodedString = current;
                current = seqStack.pop();
                while(repeat > 0){
                    current.append(decodedString);
                    repeat--;
                }
            }
        }

        return current.toString();

    }
}