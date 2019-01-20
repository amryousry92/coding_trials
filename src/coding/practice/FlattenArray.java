package coding.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlattenArray {

    private static final Logger logger = Logger.getLogger( FlattenArray.class.getName() );

    private static Object[] flattenArray(final Object[] array) {
        logger.info("Start of flattening array");
        final List<Integer> flattenedList = new ArrayList<>(); // size of flattened array is unknown so an arraylist will be used here
        if (array != null && array.length != 0) {
            final Stack<Object> stack = new Stack<>(); // stack could be used in order to solve this problem iteratively.
            // It can be replaced by a recursive method if needed.
            stack.add(array);
            while (!stack.isEmpty()) {
                final Object element = stack.pop();
                if (element instanceof int[]) {
                    // Element is composed of a flattened integer array so it will be added directly to the result array
                    for (int i : (int[]) element) {
                        flattenedList.add(i);
                    }
                } else if (element instanceof Object[]) { // Element includes other subarrays so included arrays will be pushed into stack with reversed order
                    // so that it can be popped again in correct order
                    for (int j = ((Object[]) element).length - 1; j >= 0; j--) {
                        stack.push(((Object[]) element)[j]);
                    }
                } else {
                    flattenedList.add((int) element);
                }
            }
        }
        logger.info("Array Flattened");
        return flattenedList.toArray();

    }

    public static void main(String[] args) {
        final int[] firstArray = {1, 2, 3};
        final int[] secondArray = {4, 5};
        final int[] thirdArray = {6};
        final Object[] innerArrayToBeFlattened = {7, firstArray, secondArray, thirdArray, 8};
        final Object[] secondInnerArrayToBeFlattened = {9, innerArrayToBeFlattened,
            innerArrayToBeFlattened, innerArrayToBeFlattened, 10};
        final Object[] arrayToBeFlattened = {11, secondInnerArrayToBeFlattened, 12};
        final Object[] result = flattenArray(arrayToBeFlattened);
        try {
            final StringBuilder flattenedArrayString = new StringBuilder();
            for (Object element : result) {
                flattenedArrayString.append((int) element).append(" ");
            }
            logger.info("Flattening was successful");
            logger.info(flattenedArrayString.toString());
        } catch (ClassCastException exception) {
            logger.log(Level.SEVERE, "Flattening error");
        }
    }
}
