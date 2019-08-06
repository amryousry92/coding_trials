package coding.practice;

import java.util.LinkedList;
import java.util.List;

public class NextStep {
    public String solution(int AX, int AY, int BX, int BY) {
        // write your code in Java SE 8
        if(BX == AX){
            if(BY > AY){
                return (AX+1) + "," + BY;
            }
            else {
                return (AX-1) + "," + BY;
            }
        }
        if(BY == AY){
            if(BX > AX){
                return (BX) + "," + (BY-1);
            }
            else {
                return (AX) + "," + (BY+1);
            }
        }
        String solution = "";
        float slope = (BY - AY)/(BX - AX);
        float slope2 = -1 / slope;
        float constant = BY - (slope2 * BX);
        if(BX > AX){
            for(int i = BX-1; true; i--){
                float yValue = (slope2 * i) + constant;
                if(yValue == Math.ceil(yValue)){
                    return i + "," + yValue;
                }
            }
        }
        else{
            for(int i = BX+1; true; i++){
                float yValue = (slope2 * i) + constant;
                if(yValue == Math.ceil(yValue)){
                    return i + "," + yValue;
                }
            }
        }
    }
}
