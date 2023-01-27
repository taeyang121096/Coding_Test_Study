import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int X, Y;
    static boolean[][] visit;
    static int[][] arr;
    
    public int[] solution(String[] maps) {
        List<Integer>al = new ArrayList<>();
        X = maps.length;
        Y = maps[0].length();
        
        arr = new int[X][Y];
        visit = new boolean[X][Y];
        
        for(int i = 0; i < X; i++){
            String str = maps[i];
            for(int j = 0; j < Y; j++){
                if(str.charAt(j) != 'X'){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
        }

        for(int i = 0; i < X; i++){
            for(int j = 0; j < Y; j++){
                if(arr[i][j] > 0 && !visit[i][j]){
                    al.add(bfs(i, j));
                }
            }
        }
        
        if(al.size() == 0){
            return new int[] {-1};
        }
        Collections.sort(al);
        int[] answer = new int[al.size()];
        
        for(int i = 0; i < al.size(); i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visit[r][c] = true;
        int food = arr[r][c];
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                
                if(nr >= X || nc >= Y || nr < 0 || nc < 0 || visit[nr][nc] || arr[nr][nc] == 0) continue;
                
                food += arr[nr][nc];
                visit[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }
        return food;
    }
}