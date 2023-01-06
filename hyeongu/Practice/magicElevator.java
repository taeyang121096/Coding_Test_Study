import java.util.*;

class Solution {
    public static int answer = Integer.MAX_VALUE;
    public static int size;
    public int solution(int storey) {
        size = Integer.toString(storey).length();
        dfs(storey, 0, 0);
        return answer;
    }
    
    public void dfs(int storey, int move, int depth){
        System.out.println(storey + " " + move + " " + depth);
        if(storey == 0){
            answer = Math.min(answer, move);
            return;
        }
        if(depth > size){
            return;
        }
        int c = (int)Math.pow(10, depth + 1);
        int rest = (storey % c) / (c/10);
        
        if(rest < 5){
            dfs(storey - (rest * (c/10)) , move + rest, depth + 1);
        }
        else if(rest > 5){
            dfs(storey + ((10 - rest) * (c/10)), move + 10 - rest, depth + 1);
        }
        else{
            dfs(storey - (rest * (c/10)) , move + rest, depth + 1);
            dfs(storey + ((10 - rest) * (c/10)), move + 10 - rest, depth + 1);
        }
    }
}