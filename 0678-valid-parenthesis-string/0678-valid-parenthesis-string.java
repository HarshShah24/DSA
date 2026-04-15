class Solution {
    public boolean checkValidString(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        final Stack<Integer> stack = new Stack<>();
        final Stack<Integer> wildCardStack = new Stack<>();

        int index = 0;
        while (index < input.length()) {
            char ch = input.charAt(index);
            if (ch == '*') {
                wildCardStack.push(index);
            } else if (ch == '(') {
                stack.push(index);
            } else {
                //closing bracket
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!wildCardStack.isEmpty()) {
                    //use wild card
                    wildCardStack.pop();
                } else {
                    //could satisfy the bracket
                    return false;
                }
            }
            index++;
        }

        while (!stack.isEmpty() && !wildCardStack.isEmpty()) {
            if (wildCardStack.peek() > stack.peek()) {
                wildCardStack.pop();
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}