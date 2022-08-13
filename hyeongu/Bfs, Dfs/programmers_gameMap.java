import java.util.*;

class Solution {
    static boolean[][] visit;
    static int N, M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visit = new boolean[N][M];
        maps[N-1][M-1] = -1;
        
        bfs(maps, 0, 0);
        
        return maps[N-1][M-1];
    }
    static void bfs(int[][] maps, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.offer(new int[] {x, y});
        visit[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] == N-1 && now[1] == M-1){
                return;
            }
            
            for(int i = 0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx<0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if(!visit[nx][ny] && maps[nx][ny] != 0){
                    maps[nx][ny] = maps[now[0]][now[1]] + 1;
                    visit[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}