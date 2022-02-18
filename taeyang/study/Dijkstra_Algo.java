import java.util.*;

public class Dijkstra_Algo {

    //   BFS 와 DP를 활용한 최단경로 알고리즘
//    하나의 정점에서 다른 모든 정점으로 가는 최단 경로
//    가중치가 존재할 때 사용한다. 단 음의 가중치가 없을 경우에만 사용
//    이차원 배열이랑 O(N^2), 우선순위 큐 O(NlogN)를 사용하는 방법이 존재
//    2차원 배열
    static class Graph {
        int n;
        int[][] map;

        public Graph(int n) {
            this.n = n;
            map = new int[n][n];
            for (int[] m : map) {
                Arrays.fill(m, Integer.MAX_VALUE);
            }
        }

        public void input(int i, int j, int w) {
            map[i][j] = w;
            map[j][i] = w;
        }

        public void dijkstra(int v) {

            int distance[] = new int[n];
            boolean check[] = new boolean[n];

            Arrays.fill(distance,Integer.MAX_VALUE);

            distance[v] = 0;
            check[v] = true;
//            초기화
            for(int i = 0;i<n;i++){
                if(!check[i] && map[v][i] != Integer.MAX_VALUE){
                    distance[i] = map[v][i];
                }
            }

            for(int a = 0;a<n-1;a++) {
                int min = Integer.MAX_VALUE;
                int idx = -1;

                for(int i = 0;i<n;i++){
                    if(!check[i]){
                        if(distance[i] < min){
                            min = distance[i];
                            idx = i;
                        }
                    }
                }
                check[idx] = true;
                for (int i = 0; i < n; i++) {
                    if (!check[i] && map[idx][i] !=Integer.MAX_VALUE) {
                        if (distance[idx] + map[idx][i] < distance[i]) {
                            distance[i] = distance[idx] + map[idx][i];
                        }
                    }
                }

            }
            for(int i : distance)
                System.out.print(i+" ");









        }

    }


    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.input(0, 1, 7);
        g.input(0, 2, 9);
        g.input(0, 5, 14);
        g.input(1, 2, 10);
        g.input(1, 3, 15);
        g.input(2, 3, 11);
        g.input(2, 5, 2);
        g.input(3, 4, 6);
        g.input(4, 5, 9);

        g.dijkstra(0);
    }
}
