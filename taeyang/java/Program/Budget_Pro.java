import java.util.*;
public class Budget_Pro {
    class Solution {

        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            int val = 0;
            for(int i =0;i<d.length;i++){
                if(val+d[i] <= budget){
                    val += d[i];
                    answer++;
                }else{
                    break;
                }
            }
            return answer;
        }
    }
}
