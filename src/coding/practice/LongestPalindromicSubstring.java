package coding.practice;

import java.util.*;
import java.util.stream.Collectors;

public class LongestPalindromicSubstring {


    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        if(lot == null) {
            return -1;
        }
        if(lot.get(0).get(0) == 9)
            return 0;

        int obstacleRow = 0;
        int obstacleColumn = 0;
        final int[][] distances = new int[numRows][numColumns];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numColumns;j++){
                if(i>0 && lot.get(i).get(j) != 0){
                    if(distances[i-1][j] == 0){
                        distances[i-1][j] = distances[i][j]+1;
                    }
                    else{
                        distances[i-1][j] = Math.min(distances[i-1][j], distances[i][j]+1);
                    }
                }
                if(j>0 && lot.get(i).get(j-1) != 0){
                    if(distances[i][j-1] == 0){
                        distances[i][j-1] = distances[i][j]+1;
                    }
                    else{
                        distances[i][j-1] = Math.min(distances[i][j-1], distances[i][j]+1);
                    }
                }
                if(i<numRows && lot.get(i+1).get(j) != 0){
                    if(distances[i+1][j] == 0){
                        distances[i+1][j] = distances[i][j]+1;
                    }
                    else{
                        distances[i+1][j] = Math.min(distances[i+1][j], distances[i][j]+1);
                    }
                }
                if(j<numColumns && lot.get(i).get(j+1) != 0){
                    if(distances[i][j+1] == 0){
                        distances[i][j+1] = distances[i][j]+1;
                    }
                    else{
                        distances[i][j+1] = Math.min(distances[i][j+1], distances[i][j]+1);
                    }
                }
                if(lot.get(i).get(j) == 9){
                    obstacleRow = i;
                    obstacleColumn = j;
                }
            }
        }
        return distances[obstacleRow][obstacleColumn];
    }
    
    private static String solutions(String input) {
        final int length = input.length();
        if (input == null || length <= 1) {
            return input;
        }
        String longestPalindrome = String.valueOf(input.charAt(0));
        final int[][] table = new int[length][length];
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
            if (i + 1 < length && input.charAt(i) == input.charAt(i + 1)) {
                table[i][i + 1] = 1;
                longestPalindrome = input.substring(i, i + 2);
            }
        }
        for (int k = 3; k <= length; k++) {
            for (int i = 0; i < length - k; i++) {
                int j = i + k - 1;
                if (input.charAt(i) == input.charAt(j) && table[i + 1][j - 1] == 1) {
                    table[i][j] = 1;
                    if (j + 1 - i > longestPalindrome.length()) {
                        longestPalindrome = input.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPalindrome;
    }

    static int count = 0;

    public static void printTable(int[][] x) {
        for (int[] y : x) {
            for (int z : y) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
        System.out.println("----------------" + count++);
    }

    public static void main(String[] args) {
    }


}
