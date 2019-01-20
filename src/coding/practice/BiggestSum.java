package coding.practice;

public class BiggestSum {

    private static int biggestSum(int array[]) {
        int max = 0;
        if(array!=null && array.length !=0) {
            int sum = 0;
            for (int element : array) {
                sum = ((-1 * element) < sum) ? sum + element : 0;
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2, -1, 3, 4, -1, -2, -1, 5, 4};
        System.out.println(biggestSum(array));
        System.out.println(biggestSum(null));
        System.out.println(biggestSum(new int[0]));
    }
}
