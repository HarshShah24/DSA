class Solution {
    public String decodeString(String s) {
        
        final Stack<Integer> freqStack = new Stack<>(); 
        final Stack<StringBuilder> strStack = new Stack<>();

        int index = 0;
        StringBuilder seq = new StringBuilder();
        int freq = 0;

        while(index < s.length()){
            final char ch = s.charAt(index);
            if(Character.isDigit(ch)){
                
                StringBuilder value = new StringBuilder();
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    value.append(s.charAt(index++));
                }

                freq = Integer.parseInt(value.toString());
                continue;

            }else if(ch == '['){
                freqStack.push(freq);
                strStack.push(seq);

                seq = new StringBuilder();
                freq = 0;


            }else if(Character.isAlphabetic(ch)){ 
                seq.append(ch);
            }else{ //Closing Brace
                
                int repeatTimes = freqStack.pop();
                StringBuilder previousContext = strStack.pop();
                
                // Append the current decoded segment 'repeatTimes' times to the previous context
                for (int i = 0; i < repeatTimes; i++) {
                    previousContext.append(seq);
                }
                // The previous context updated with the repetitions is now our active sequence
                seq = previousContext;

            }
            index++;
        }

        return seq.toString();

    }
}