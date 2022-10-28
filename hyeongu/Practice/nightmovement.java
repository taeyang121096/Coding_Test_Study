import java.util.*;

class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = distance;
        
        for(int i = 0; i<scope.length; i++){
            Arrays.sort(scope[i]);
            
            for(int j = scope[i][0]; j <= scope[i][1]; j++){
                if((j-1) % (times[i][0] + times[i][1]) < times[i][0]){
                    answer = Math.min(answer, j);
                    continue;
                }
            }
        }
        return answer;
    }
}