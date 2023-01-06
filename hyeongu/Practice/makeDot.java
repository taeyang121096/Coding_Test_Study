import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int b = d / k * k;
        
        for(int a = 0; a <= d; a+=k){
            while(true){
                if(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) <= d){
                    answer += b/k + 1;
                    break;
                }
                else{
                    b -= k;
                }
            }
        }
        
        return answer;
    }
}