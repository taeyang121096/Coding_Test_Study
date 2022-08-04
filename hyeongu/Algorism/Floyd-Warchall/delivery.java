// {마을1, 마을2, 거리} 형태로 입력
// N<=50, road<=2000, c<=10000, K<=500000
// 1번 마을에서 K이하 시간에 배달이 가능한 마을의 개수를 return

import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] dt = new int[N][N];
        for(int i = 0; i<N; i++){
            Arrays.fill(dt[i], 500001);
            dt[i][i] = 0;
        }
        for(int[] tmp: road){
            dt[tmp[0]-1][tmp[1]-1] = Math.min(dt[tmp[0]-1][tmp[1]-1], tmp[2]);
            dt[tmp[1]-1][tmp[0]-1] = Math.min(dt[tmp[1]-1][tmp[0]-1], tmp[2]);          
        }
        
        for(int k = 0; k<N; k++){
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    dt[i][j] = Math.min(dt[i][j], dt[i][k] + dt[k][j]);
                }
            }
        }
        for(int i = 0; i<dt[0].length; i++){
            if(dt[0][i]<=K){
                answer++;
            }
        }
        return answer;
    }
}