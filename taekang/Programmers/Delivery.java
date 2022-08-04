///**
// 1~N 개의 번호, 양방향으로 통행이 가능
// 1번 마을의 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수만 구하면 됨
// **/
//class Solution {
//    public int solution(int N, int[][] road, int K) {
//        int answer = 1;
//        int INF = 500001;
//        int[][] list = new int[N][N];
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                if(i != j){
//                    list[i][j] = INF;
//                }
//            }
//        }
//
//        for(int i = 0; i < road.length; i++){
//            int x = road[i][0] - 1;
//            int y = road[i][1] - 1;
//            int cost = Math.min(list[x][y], road[i][2]);
//            list[x][y] = list[y][x] = cost;
//        }
//
//        for(int k = 0; k < N; k++){ // 경유지
//            for(int i = 0; i < N; i++){ // 출발지
//                if(i == k) continue; // 경유지와 출발지가 같다면 스킵
//                for(int j = 0; j < N; j++){ // 도착지
//                    if(j==k || i==j) continue; // 경우지와 도착지가 같거나 출발지와 도착지가 같다면 스킵
//                    list[i][j] = Math.min(list[i][k] + list[k][j], list[i][j]);
//                }
//            }
//        }
//
//        for(int i = 1; i < N; i++){
//            if(list[0][i] <=K)
//                answer++;
//        }
//
//        // for(int i = 0; i < N; i++){
//        //     for(int j = 0; j < N; j++){
//        //         System.out.print(list[i][j] + " ");
//        //     }
//        //     System.out.println();
//        // }
//
//        return answer;
//    }
//}