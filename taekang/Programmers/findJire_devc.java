///**
// N*N 크기의 게임보드
// 먼저 하나하나 근처의 지뢰개수를 탐색해서 map을 채워놓은 다음에 해당 버튼을 눌렀을때 나올 칸 의 갯수를 출력해보자
// **/
//import java.util.*;
//class Solution {
//    public int[][] map;
//    public int n;
//    public boolean[][] check;
//    public int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1, -1}, {-1, 1}, {-1, -1}};
//    public int solution(int N, int[][] mine, int[] P) {
//        n = N;
//        map = new int[N][N]; // 다 0으로 채워짐 일단, mine은 8까지가 최대니까 9로 설정할까
//        for(int i = 0; i < mine.length; i++){
//            map[mine[i][0] - 1][mine[i][1] - 1] = 9;
//        }
//
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                if(map[i][j] != 9)
//                    fillNumber(i,j);
//            }
//        }
//        check = new boolean[N][N];
//        int answer = bfs(P[0], P[1]);
//        return answer;
//    }
//
//    // public int bfs(int r, int c, int cnt){
//    public int bfs(int r, int c){
//        Queue<int[]> q = new ArrayDeque<>();
//        // q.offer(new int[]{r, c, cnt});
//        q.offer(new int[]{r, c});
//        check[r][c] = true;
//        int cnt = 1;
//        while(!q.isEmpty()){
//            int[] tmp = q.poll();
//            for(int i = 0; i < 8; i++){
//                int nr = tmp[0] + dir[i][0];
//                int nc = tmp[1] + dir[i][1];
//                // cnt = tmp[2];
//
//                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !check[nr][nc] && map[nr][nc] == 0){
//                    // q.offer(new int[]{nr, nc, cnt+1});
//                    cnt++;
//                    q.offer(new int[]{nr, nc});
//                    check[nr][nc] = true;
//                } else if(nr >= 0 && nc >= 0 && nr < n && nc < n && !check[nr][nc] && map[nr][nc] != 0 && map[nr][nc] != 9){
//                    check[nr][nc] = true;
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }
//
//    public void fillNumber(int r, int c){
//        int cnt = 0;
//
//        for(int[] d : dir){
//            int nr = d[0] + r; //
//            int nc = d[1] + c; //
//            if(nr >= 0 && nc >= 0 && nr < n && nc < n){ // 만약 쟤내가 범위를 벗어나지않는데,
//                if(map[nr][nc] == 9){
//                    cnt++;
//                }
//            }
//        }
//        map[r][c] = cnt;
//    }
//}