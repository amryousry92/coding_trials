package coding.practice;

public class MaxProfit {

    private static int maxProfitOneTransaction(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int min = array[0];
        int max = array[0];
        int minIndex = 0;
        int difference = 0;
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            if (x > max) {
                max = x;
                maxIndex = i;
            }
            if (x < min) {
                min = x;
                minIndex = i;
            }
            if (max - min > difference && minIndex < maxIndex) {
                difference = max - min;
            }
        }
        return difference;
    }

    private static int maxProfitKTransactions(int[] array, int k) {
        LocalValue[] maxValues = new LocalValue[k];
        int counter = 0;
        if (array[array.length - 1] > array[array.length - 2]) {
            maxValues[counter++] = new LocalValue(array.length - 1, array[array.length - 1]);
        }
        for (int i = array.length - 2; i > 0; i--) {
            if (array[i] > array[i + 1] && array[i] > array[i - 1]) {
                if (counter < k) {
                    maxValues[counter++] = new LocalValue(i, array[i]);
                } else {
                    int index = getMinIndex(maxValues);
                    if (maxValues[index].value < array[i]) {
                        addToIndex(index, maxValues, new LocalValue(i, array[i]));
                    }
                }
            }
        }
        int difference = 0;
        int minCounter = 0;
        System.out.println(counter);
        System.out.println("----------------------------- counter");
        for (int j = counter - 1; j >= 0; j--) {
            int min = Integer.MAX_VALUE;
            System.out.println(maxValues[j].index);
            System.out.println(maxValues[j].value);
            System.out.println("-----------------------------");
            for (int i = minCounter; i < maxValues[j].index; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            difference += (maxValues[j].value - min);
            minCounter = maxValues[j].index + 1;
        }
        return difference;
    }

    private static void addToIndex(int index, LocalValue[] maxValues,
        LocalValue localValue) {
        for (int i = index; i < maxValues.length - 1; i++) {
            maxValues[i] = maxValues[i + 1];
        }
        maxValues[maxValues.length - 1] = localValue;
    }

    private static int getMinIndex(LocalValue[] array) {
        int index = array.length - 1;
        LocalValue min = new LocalValue(0, Integer.MAX_VALUE);
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i].value < min.value) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {10, 11, 12, 3, 5, 2, 6, 7, 2, 465, 22, 4, 6, 32, 1, 4};
        System.out.println(maxProfitOneTransaction(array));
        System.out.println(maxProfitKTransactions(array, 1));
    }

    private static class LocalValue {

        int index;
        int value;

        LocalValue(int i, int v) {
            index = i;
            value = v;
        }
    }
}
