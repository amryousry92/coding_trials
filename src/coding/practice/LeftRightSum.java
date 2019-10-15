package coding.practice;

public class LeftRightSum {


    //    Given an array of integers if size n. Get the index where the sum of the left is equal to
    //    the sum of the right in O(n) and memory O(1). If there is no such index return -1.
    private static int getIndex(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int leftSum = array[i];
        int rightSum = array[j];
        while (j - i > 1) {
            if (leftSum > rightSum) {
                rightSum += array[--j];
            } else if (rightSum > leftSum) {
                leftSum += array[++i];
            } else {
                leftSum += array[++i];
                rightSum += array[--j];
            }
        }
        return (leftSum == rightSum) ? i : -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 9};
        System.out.println(getIndex(array));
    }
}
