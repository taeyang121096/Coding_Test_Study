// 147 -> L      369 -> R       2580 -> 가까운 손가락 같을경우 hand

import java.util.*;

class Solution {
    public int distance(int a, int b){
        int x, y;
        int ax = (a-1)/3;
        int ay = (a-1)%3;
        int bx = (b-1)/3;
        int by = (b-1)%3;
        
        return Math.abs(ax-bx)+Math.abs(ay-by);
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        int next;
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i]==0){
                next = 11;
            }
            else{
                next = numbers[i];
            }
            if(next%3==1){
                sb.append("L");
                left = next;
            }
            else if(next%3==0){
                sb.append("R");
                right = next;
            }
            else{
                if(distance(left, next)>distance(right, next)){
                    sb.append("R");
                    right = next;
                }
                else if(distance(left, next)<distance(right, next)){
                    sb.append("L");
                    left = next;
                }
                else{
                    if(hand.equals("left")){
                        sb.append("L");
                        left = next;
                    }
                    else{
                        sb.append("R");
                        right = next;
                    }
                }
            }
        }
        return answer = sb.toString();
    }
}