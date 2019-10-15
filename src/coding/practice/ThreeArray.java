package coding.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreeArray {

    private static Set<Integer> solution(int[] A, int[] B, int[] C) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            }
        }

        for (int b : B) {
            if (!map.containsKey(b)) {
                map.put(b, 2);
            } else if (map.get(b) == 1) {
                map.put(b, 4);
            }
        }

        for (int c : C) {
            if (map.containsKey(c) && (map.get(c) == 1 || map.get(c) == 2)) {
                map.put(c, 4);
            }
        }
        return constructSetFromMap(4, map);
    }

    private static Set<Integer> constructSetFromMap(int i, Map<Integer, Integer> map) {
        Set<Integer> result = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == i) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private static Set<Integer> solution2(int[][] list, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            Set<Integer> recent = new HashSet<>();
            for (int x : list[i]) {
                if (!map.containsKey(x)) {
                    map.put(x, 1);
                } else if (map.get(x) < k && !recent.contains(x)) {
                    map.put(x, map.get(x) + 1);
                }
                recent.add(x);
            }
        }

        return constructSetFromMap(k, map);
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 3, 2, 8, 1};
        int[] B = {7, 9, 5, 2, 4, 10, 10};
        int[] C = {6, 7, 5, 5, 3, 7, 2};
        int[] D = {5, 5, 5, 5, 5, 5, 5, 5};

        Set<Integer> result = solution(A, B, C);

        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
        int[][] list = {A, B, C, D};
        int k = 4;
        Set<Integer> result2 = solution2(list, k);
        for (int y : result2) {
            System.out.print(y + " ");
        }
    }
}
