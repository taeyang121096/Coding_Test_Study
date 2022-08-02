///**
// 전선 하나 끊어 네트워크를 2개로 분할하려고 함 -> 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞춤
// 두 전력망의 송전탑 개수의 차이를 절대값으로 return
// i번째는 스킵하고, map[x][y] = map[y][x] = 1 인거
// **/
//import java.util.*;
//class Solution {
//    public int[][] map;
//    public boolean[] check;
//    public int solution(int n, int[][] wires) {
//        List<Integer> list = new ArrayList<>();
//
//        int answer = Integer.MAX_VALUE;;
//        for(int i = 0; i < wires.length; i++){
//            map = new int[n][n];
//            check = new boolean[n];
//            // i = 0;
//            for(int j = 0; j < wires.length; j++){
//                if(i != j){ // 0 != 0
//                    int x = wires[j][0] - 1; // 7 - 1
//                    int y = wires[j][1] - 1; // 9 - 1
//                    map[x][y] = map[y][x] = 1;
//                }
//            }
//
//            for(int j = 0; j < n; j++){
//                int cnt = 0;
//                if(!check[j]){
//                    int x = bfs(n, j); // 몇개ㅑ 몇개
//                    list.add(x);
//                }
//            }
//            answer = Math.min(answer, Math.abs(list.get(0) - list.get(1)));
//            list.clear();
//
//        }
//        return answer;
//    }
//
//    public int bfs(int n, int idx){ // 9, 0
//        Queue<Integer> q = new LinkedList<>(); //
//        int cnt = 0;
//        q.offer(idx); // 0
//        check[idx] = true;
//        while(!q.isEmpty()){
//            int x = q.poll();
//            for(int i = 0; i < n; i++){ // 0 1 2 3 4 5 6 7 8
//                if(!check[i] && map[x][i] == 1){
//                    q.offer(i);
//                    check[i] = true;
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }
//}