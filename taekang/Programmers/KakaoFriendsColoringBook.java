//// 1 1 1 0
//// 1 2 2 0
//// 1 0 0 1
//// 0 0 0 1
//// 0 0 0 3
//// 0 0 0 3
//import java.util.*;
//class Solution {
//    public int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//    public boolean[][] check;
//    public int[][] map;
//    public int max = Integer.MIN_VALUE;
//    public int[] solution(int m, int n, int[][] picture) {
//        int[] answer = new int[2];
//        int numberOfArea = 0;
//        int maxSizeOfOneArea = 0;
//        map = new int[m][n];
//        check = new boolean[m][n];
//        // map 에 내용물 채우기
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                map[i][j] = picture[i][j];
//            }
//        }
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(!check[i][j] && map[i][j] != 0){
//                    max = Math.max(max, bfs(m,n,i,j));
//                    numberOfArea++;
//                }
//            }
//        }
//
//        answer[0] = numberOfArea;
//        answer[1] = max;
//
//        return answer;
//    }
//    public int bfs(int m, int n, int r, int c){
//        int area = 1;
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{r,c});
//        check[r][c] = true;
//        while(!q.isEmpty()){
//            int[] tmp = q.poll();
//
//            for(int[] d : dir){
//                int nr = tmp[0] + d[0];
//                int nc = tmp[1] + d[1];
//                if(nr>=0 && nr<m && nc>=0 && nc<n && !check[nr][nc] && map[nr][nc] == map[r][c]){
//                    q.offer(new int[]{nr, nc});
//                    area++;
//                    check[nr][nc] = true;
//                }
//            }
//        }
//        return area;
//    }
//}