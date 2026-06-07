class Solution {
    public boolean isValid(String s) {
        
        final Deque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty() && isMatchingParenthesis(stack.peek(),ch)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

    public boolean isMatchingParenthesis(Character open, Character close){
        if(open == '(' && close == ')'){
            return true;
        }
        if(open == '{' && close == '}'){
            return true;
        }
        if(open == '[' && close == ']'){
            return true;
        }
        return false;
    }
}