package coding.practice;

import java.util.Stack;

public class ValidParenthesis {

    private static int longestValidParenthesis(String parenthesis) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < parenthesis.length(); i++) {
            char c = parenthesis.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek()[0] == 0) {
                    stack.pop();
                    max = Math.max(max, stack.empty() ? i + 1 : i - stack.peek()[1]);
                } else {
                    stack.push(new int[]{1, i});
                }
            } else {
                stack.push(new int[]{0, i});
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String parenthesis = "(())((())))(())((()";
        System.out.println(longestValidParenthesis(parenthesis));
    }
}
