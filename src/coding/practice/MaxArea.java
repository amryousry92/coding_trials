package coding.practice;

import java.util.Stack;

public class MaxArea {

    public static double maxArea(int[] heights) {
        final Stack<Integer> stack = new Stack<>();
        int i = 0;
        double maxArea = 0;
        while (i < heights.length) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int currentIndex = stack.pop();
                maxArea = Math.max(maxArea,
                    heights[currentIndex] * ((stack.empty()) ? i : i - 1 - stack.peek()));
            }
        }
        while (!stack.empty()) {
            int currentIndex = stack.pop();
            maxArea = Math
                .max(maxArea, heights[currentIndex] * ((stack.empty()) ? i : i - 1 - stack.peek()));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }
}
