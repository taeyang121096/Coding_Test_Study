// 같은 색으로 연결되어있는 영역의 갯수, 영역 중 가장 큰 영역의 크기 return
// 색은 int로 주어지고 0은 색칠하지 않는 영역

import java.util.*;

class Solution {
    static boolean isVisit[][];
    static int count = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        isVisit = new boolean[m][n];
        int[] answer = new int[2];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] != 0 && !isVisit[i][j]){
                    answer[0]++;
                    dfs(picture, i, j);
                    if(count>answer[1]){
                    answer[1] = count;
                }
                count = 0;
                }
            }
        }
        return answer;
    }
    
    public void dfs(int[][] picture, int x, int y){
        
        isVisit[x][y] = true;
        count++;
        
        for(int i = 0; i< 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=0&&nx<picture.length&&ny>=0&&ny<picture[0].length){
                if(picture[x][y]==picture[nx][ny] && !isVisit[nx][ny]){
                    dfs(picture, nx, ny);
                }
            }
        }
    }
}