package dynamicprogramming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TripleStep {

    private static final Set<Integer> MOVES = Collections
        .unmodifiableSet(new HashSet<Integer>(Arrays.asList(0, 1, 2, 3)));

    private static BigInteger neededSteps(int n) {
        if (n < 0) {
            return BigInteger.valueOf(0);
        }
        if (n == 0) {
            return BigInteger.valueOf(1);
        }
        final BigInteger[] moves = new BigInteger[n + 1];
        for (int i = 1; i < n + 1; i++) {
            moves[i] = BigInteger.valueOf(0);
            if (MOVES.contains(i)) {
                moves[i] = moves[i].add(BigInteger.valueOf(1));
            }
            if (i > 1) {
                moves[i] = moves[i].add(moves[i - 1]);
            }
            if (i > 2) {
                moves[i] = moves[i].add(moves[i - 2]);
            }
            if (i > 3) {
                moves[i] = moves[i].add(moves[i - 3]);
            }
        }
        return moves[n];
    }

    public static void main(String[] args) {
        System.out.println(neededSteps(3));
    }
}
