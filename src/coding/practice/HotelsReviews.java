package coding.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class HotelsReviews {

    static class Pair {

        int order;
        int score;

        Pair(int l, int s) {
            order = l;
            score = s;
        }
    }

    public static int[] solve(String A, String[] B) {
        Set<String> good = new HashSet<>();
        for (String word : A.split("_")) {
            good.add(word);
        }
        Pair[] pairs = new Pair[B.length];
        for (int i = 0; i < B.length; i++) {
            int score = 0;
            for (String word1 : B[i].split("_")) {
                if (good.contains(word1)) {
                    score++;
                }
            }
            Pair newPair = new Pair(i, score);
            pairs[i] = newPair;
        }
        Arrays.sort(pairs, (o1,o2) -> o2.score-o1.score);
        int[] result = new int[pairs.length];
        for (int k = 0; k < result.length; k++) {
            result[k] = pairs[k].order;
            System.out.print(pairs[k].score);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] reviews = {
            "cool_wifi_speed", "water_is_cool", "cold_ice_drink"
        };
        int[] result = solve("cool_ice_wifi", reviews);
        System.out.println("\n===================================================");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
