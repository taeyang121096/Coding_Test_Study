///**
// 집-회사 직선 경로, n 개의 구간으로 나뉘어 있다.
// 각, 구간별로 대중교통 이동할 때 걸리는 시간이 정해져 있다.
// 각 구간은 반드시 하나의 교통 수단으로만 이동해야 한다.
//
// 1. 자동차로 이동할 경우 모든 구간 자동차 사용
// 2. 자전거 이동한다면 각 구간별로 자전거, 도보
// 3. 대중교통으로 이동한다면 각 구간별로 대중교통이나 도보
// 4. 도보로 이동하는 경우 연속해서 최대 m 분
// 5. 번호가 작은 순서대로
// **/
//import java.util.*;
//
//class Solution {
//    public int solution(int[][] infos, int m) {
//        int answer = 0;
//        int min = Integer.MAX_VALUE; //
//        int time = 0;
//
//        // 자동차 소요시간
//        for(int i = 0; i < infos.length; i++){
//            time += infos[i][0];
//        }
//        min = Math.min(min, time); // 20 + 50 + 10 + 40
//        time = 0;
//
//        // 자전거 소요시간 (자전거 소요시간과 도보 소요시간 중 작은걸 고르는데, 연속하는 도보 시간이 m을 넘어가면 안됨)
//        // flag 가 만약 false다 -> 계속 최솟값 고른다, flag 가 만약 true 다 -> 자전거 무조건 고르고 time 초기화
//        // 80 || 20
//        // 60 || 40
//        // m = 30
//
//        int sum = 0;
//        for(int i = 0; i < infos.length; i++){
//            if(infos[i][1] <= infos[i][3]){
//                sum += infos[i][1]; //
//                time = 0;
//            } else {
//                sum += infos[i][3]; // 60
//                time += infos[i][3]; // 60
//            }
//
//            if(time > m){
//                sum -= infos[i][3];
//                sum += infos[i][1];
//                time = 0;
//            }
//        }
//        min = Math.min(min, sum);
//
//        // 대중교통 소요시간
//        sum = 0;
//        // sum, time = 10,0
//        // 10 || 20
//        // -1 || 40
//        // m = 30
//        for(int i = 0; i < infos.length; i++){
//            if(infos[i][2] == -1){
//                sum += infos[i][3]; //
//                time += infos[i][3]; //
//            } else {
//                if(infos[i][2] <= infos[i][3]){
//                    sum += infos[i][2]; //
//                    time = 0;
//                } else {
//                    sum += infos[i][3]; // 60
//                    time += infos[i][3]; // 60
//                }
//            }
//
//            if(time > m){
//                sum -= infos[i][3];
//                if(infos[i][2] != -1) sum += infos[i][2];
//                else{
//                    sum = Integer.MAX_VALUE;
//                    break;
//                }
//                time = 0;
//            }
//        }
//        min = Math.min(min, sum);
//
//        sum = 0;
//        for(int i = 0; i < infos.length; i++){
//            sum += infos[i][3];
//        }
//        if(sum <= m){
//            min = Math.min(min, sum);
//        }
//
//        return min;
//    }
//}