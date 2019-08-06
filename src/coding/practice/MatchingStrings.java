package coding.practice;

public class MatchingStrings {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String INSERT = "INSERT ";
    private static final String REPLACE = "REPLACE ";
    private static final String SWAP = "SWAP ";
    private static final String EQUAL = "EQUAL";
    private static final String SPACE = " ";

    public String solution(String S, String T) {
        // write your code in Java SE 8
        int min = Math.min(S.length(), T.length());
        int max = Math.max(S.length(), T.length());
        String minString = (S.length() > T.length())? T : S;
        String maxString = (S.length() > T.length())? S : T;

        if(max - min >= 2){
            return IMPOSSIBLE;
        }
        String solution = EQUAL;
        int j = 0;
        for(int i=0;i<min; i++){
            if(minString.charAt(i) != maxString.charAt(j)){
                if(!solution.equals(EQUAL)) {
                    return IMPOSSIBLE;
                }
                else {
                    if(minString.charAt(i+1) == maxString.charAt(j)){
                        solution = INSERT + minString.charAt(i);
                        j--;
                    } else if (minString.charAt(i) == maxString.charAt(j+1)){
                        solution = INSERT + maxString.charAt(j);
                        i--;
                    }
                    else if (minString.charAt(i+1) == maxString.charAt(j+1)){
                        solution = REPLACE + minString.charAt(i) + SPACE + maxString.charAt(j);
                    }
                    else if (minString.charAt(i+1) == maxString.charAt(j)
                        && maxString.charAt(j+1) == minString.charAt(i)){
                        solution = SWAP + minString.charAt(i) + SPACE + minString.charAt(i+1);
                    }
                }
            }
            j++;
        }
        if(j != maxString.length()-1){
            if(!solution.equals(EQUAL)) {
                solution = IMPOSSIBLE;
            }
            else {
                solution = INSERT + maxString.charAt(j+1);
            }
        }
        return solution;
    }
}
