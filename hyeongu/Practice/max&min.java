import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        int max = Integer.parseInt(st.nextToken());
        int min = max;
            
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > max){
                max = tmp;
            }
            if(tmp < min){
                min = tmp;
            }
        }
        sb.append(min).append(" ").append(max);
            
        return sb.toString();
    }
}