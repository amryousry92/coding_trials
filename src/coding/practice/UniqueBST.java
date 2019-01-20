package coding.practice;

public class UniqueBST {

    public static void main(String[] args) {
        System.out.println(validBSTs(4));
    }

    private static int validBSTs(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
