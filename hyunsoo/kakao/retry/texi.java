package kakao.retry;
import java.util.*;
public class texi {
class Solution {
    int max=20000001;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] arr = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++){
            Arrays.fill(arr[i],max);
            arr[i][i]=0;
        }
        
        for(int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            
            arr[start][end]=cost;
            arr[end][start]=cost;
        }
        
        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        
        int answer = arr[s][a]+arr[s][b];
        
        for(int i=1; i<n+1; i++){
            answer = Math.min(answer, arr[s][i]+arr[i][a]+arr[i][b]);
        }
        
        return answer;
    }
}
}
