import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[][] arr = new int[rows][columns];
        int[] answer = new int[queries.length];
        Queue<Integer>q = new LinkedList<>();
        int tmp = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = tmp++;
            }
        }

        for(int i = 0; i<queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int min = rows*columns;
            
            int x = x1;
            int y = y1;
            int dir = 0;
            
            q.offer(arr[x][y]);
            
            while(true){
                if(x+dx[dir] > x2 || y+dy[dir] > y2 || x+dx[dir] < x1 || y+dy[dir] < y1){
                    dir++;
                    if(dir == 4){
                        break;
                    }
                }
                x = x + dx[dir];
                y = y + dy[dir];
                
                q.offer(arr[x][y]);
                arr[x][y] = q.poll();
                
                min = Math.min(min, arr[x][y]);
            }
            answer[i] = min;
            q.poll();
        }
        return answer;
    }
}