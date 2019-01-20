package coding.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    private static Set<String> OPERATORS = Collections.unmodifiableSet(
        new HashSet<>(Arrays.asList("+", "-", "*", "/")));

    private static int solution(String[] input) {
        final Stack<String> stack = new Stack<>();
        int result = 0;
        try {
            if (input != null) {
                for (String element : input) {
                    if (OPERATORS.contains(element)) {
                        int element2 = Integer.parseInt(stack.pop());
                        int element1 = Integer.parseInt(stack.pop());
                        switch (element.charAt(0)) {
                            case '+':
                                stack.push(Integer.toString(element1 + element2));
                                break;
                            case '-':
                                stack.push(Integer.toString(element1 - element2));
                                break;
                            case '*':
                                stack.push(Integer.toString(element1 * element2));
                                break;
                            case '/':
                                stack.push(Integer.toString(element1 / element2));
                                break;
                        }
                    } else {
                        stack.push(element);
                    }
                }
            }
            result = Integer.parseInt(stack.pop());
        } catch (EmptyStackException exception) {
            System.out.println("Ill formed array...Character ignored");
        }
        if(!stack.isEmpty()){
            System.out.println("Ill formed input");
        }
        return result;
    }

    public static void main(String[] args) {
        final String[] input = {"2", "8", "3", "-", "*","2", "/"};
        System.out.println(solution(input));
    }
}
