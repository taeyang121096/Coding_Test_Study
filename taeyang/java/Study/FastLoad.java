import java.util.*;
import java.io.*;
public class FastLoad {
//    방향그래프 시작 정점 -> 모든 정점의 최단 경로 가중치 <=10
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] check;
    static class Node implements Comparable<Node>{
        int index;
        int weight;
        public Node(int index,int weight){
            this.index = index;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node n){
            if(n.weight == this.weight)
                return this.index - n.index;
            return this.weight - n.weight;
        }
    }
    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        while(!q.isEmpty()) {
            Node n = q.poll();
            int index = n.index;
            check[index] = true;

                for (Node node :list[index]) {
                    if (!check[node.index]) {
                        if (dist[node.index] > node.weight + dist[index]) {
                            dist[node.index] = node.weight + dist[index];
                            q.add(new Node(node.index, dist[node.index]));
                        }
                    }
                }

        }



    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt( st.nextToken());
        int e = Integer.parseInt( st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int k = Integer.parseInt(st.nextToken());

        check = new boolean[v+1];
        dist = new int[v+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k] = 0;
        check[k] = true;
        list = new ArrayList[v+1];
        for(int i = 1;i<=v;i++)
            list[i] = new ArrayList<>();

        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second =Integer.parseInt(st.nextToken());
            int weight =Integer.parseInt(st.nextToken());
            list[first].add(new Node(second,weight));
        }

        dijkstra(k);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=v;i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(dist[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();


    }
}
