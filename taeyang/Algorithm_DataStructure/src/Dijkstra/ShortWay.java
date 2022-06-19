package Dijkstra;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortWay {

    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
//    다익스트라 (모든)!! 최단 경로 구할시 사용
    static void dijstra(int start){
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
//        초기화
        q.offer(new Node(start,0));

        while(!q.isEmpty()){
            Node no = q.poll();
            if(dist[no.idx] < no.cost)
                continue;

            for(int i = 0;i< list.get(no.idx).size();i++){
                Node nx = list.get(no.idx).get(i);
                if(dist[nx.idx] > no.cost + nx.cost){
                    dist[nx.idx] = no.cost + nx.cost;
                    q.offer(new Node(nx.idx,dist[nx.idx]));
                }
            }
        }
    }

    static int[] dist;
    static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[v+1];

        st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
//      초기화
        for(int i = 0;i<=v;i++){
            list.add(new ArrayList<Node>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(V,w));
        }
        dist[s] = 0;

        dijstra(s);

        for(int i = 1;i<=v;i++){
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }


    }
}
