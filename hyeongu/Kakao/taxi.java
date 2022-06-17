import java.util.*;

class Solution {
    static int[][] array;
    static int max = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] farqes) {
        
        array = new int[n+1][n+1];
        int[] s_arr = new int[n+1];
        int[] a_arr = new int[n+1];
        int[] b_arr = new int[n+1];
        int answer = Integer.MAX_VALUE;
        
        for(int[] index:farqes){
            array[index[0]][index[1]] = index[2];
            array[index[1]][index[0]] = index[2];
        }
        
        s_arr = dijkstra(s, n);
        a_arr = dijkstra(a, n);
        b_arr = dijkstra(b, n);
        

        
        for(int i = 1; i<n+1; i++){
            if(answer > s_arr[i] + a_arr[i] + b_arr[i]){
                answer = s_arr[i] + a_arr[i] + b_arr[i];
            }
        }
        return answer;
    }
    
    public int[] dijkstra(int start, int n){
        int[] dist = new int[n+1];
        boolean[] visit = new boolean[n+1];
        
        for(int i=1; i < n+1; i++){
            if(array[start][i]!=0)
                dist[i] = array[start][i];
            else
                dist[i] = max;
        }
        
        dist[start] = 0;
        visit[start] = true;
        
        for(int k = 0; k<n-1; k++){
            int min = max;
            int index = 0;
            
            for(int i = 1; i<n+1; i++)
                if(!visit[i] && dist[i]!=max)
                    if(dist[i]<min){
                        min = dist[i];
                        index = i;
                    }
            
            visit[index] = true;
            for(int i = 1; i<n+1; i++)
                if(!visit[i] && array[index][i] !=0)
                    if(dist[i]>dist[index]+array[index][i])
                        dist[i] = dist[index] + array[index][i];
        }
        return dist;
    }
}