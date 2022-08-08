package Programmers;///**
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
import java.util.*;
public class Delivery{
    static class Node{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        int N = 5;
        int INF = 500001;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        // 노드의 번호가 1부터 시작하므로, 0번 인덱스 부분을 임의로 만들어 놓기만 한다.
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        // 그래프에 값을 넣는다
        for(int i = 0; i < road.length; i++){
            int x = road[i][0] - 1;
            int y = road[i][1] - 1;
//            int cost = Math.min(graph.get(x).get(y).cost, road[i][2]);
            int cost = road[i][2];
            graph.get(x).add(new Node(y, cost));
        }

        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        for(int i = 0; i < N; i++){
            dist[i] = INF;
        }
        // 첫 시작 부분은 0으로 시작해야 한다
        dist[1] = 0;

        // 다익스트라 알고리즘을 진행한다, 노드의 개수 만큼만 반복 한다
        for (int i = 0; i < N; i++) {
            // 4 - 1. 현재 거리 비용 중 최소인 지점을 선택한다.
            // 해당 노드가 가지고 있는 현재 비용.
            int nodeValue = INF;
            // 해당 노드의 인덱스(번호).
            int nodeIdx = 0;
            // 인덱스 0은 생각하지 않기 때문에 0부터 반복을 진행한다.
            for (int j = 1; j < N ; j++) {
                // 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            // 최종 선택된 노드를 방문처리 한다.
            visited[nodeIdx] = true;

            // 4 - 2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                // 인접 노드를 선택한다.
                Node adjNode = graph.get(nodeIdx).get(j);
                // 인접 노드가 현재 가지는 최소 비용과
                // 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 더 작은 값으로 갱신한다.
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }
        for (int i = 0; i < N + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}