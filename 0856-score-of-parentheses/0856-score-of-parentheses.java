class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(0);
            } else {
                int x = stack.pop();
                int top = stack.pop();

                if (x == 0) {
                    stack.push(top + 1);
                } else {
                    stack.push(top + 2 * x);
                }
            }
        }

        return stack.pop();
    }
}