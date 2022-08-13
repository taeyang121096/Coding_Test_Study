import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        
        
        visit = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    public void dfs(int k, int[][] arr, int depth){
        for(int i = 0; i<arr.length; i++){
            if(!visit[i] && arr[i][0] <= k){
                break;
            }
            if(i == arr.length-1){
                answer = Math.max(answer, depth);
                return;
            }
        }
        
        for(int i = 0; i<arr.length; i++){
            if(k < arr[i][0] || visit[i]){
                continue;
            }
            visit[i] = true;
            dfs(k-arr[i][1], arr, depth + 1);
            visit[i] = false;
        }
    }
}