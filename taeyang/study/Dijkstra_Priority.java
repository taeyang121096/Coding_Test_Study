import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra_Priority {
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

        class Node {
            int weight;
            int index;

            public Node(int weight, int index) {
                this.weight = weight;
                this.index = index;
            }
        }

        public void input(int i, int j, int w) {
            map[i][j] = w;
            map[j][i] = w;
        }

        public void dijkstra(int v) {
            PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.weight > o2.weight ? 1 : -1;
                }
            });

            int distance[] = new int[n];
            boolean check[] = new boolean[n];

            Arrays.fill(distance, Integer.MAX_VALUE);
            q.offer(new Node(v, 0));
            distance[v] = 0;
            check[v] = true;
//            초기화
            for (int i = 0; i < n; i++) {
                if (!check[i] && map[v][i] != Integer.MAX_VALUE) {
                    distance[i] = map[v][i];
                    q.offer(new Node(map[v][i], i));
                }
            }
            while (!q.isEmpty()) {

                Node no = q.poll();

                int idx = no.index;
                check[idx] = true;
                for(int i = 0;i<n;i++){
                    if(!check[i] && map[idx][i] != Integer.MAX_VALUE){
                        if(distance[idx]+map[idx][i] < distance[i]){
                            distance[i] =distance[idx]+map[idx][i];
                            q.offer(new Node(distance[i],i));
                        }
                    }
                }

            }
            for(int i: distance)
                System.out.print(i+" ");


        }


        public static void main(String[] args) {
            Dijkstra_Algo.Graph g = new Dijkstra_Algo.Graph(6);

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
}
