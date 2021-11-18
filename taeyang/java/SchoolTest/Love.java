package School;
import java.util.*;
import java.io.*;
public class Love {


    static class Node implements Comparable<Node>{
        int dst;
        int weight;
        public Node(int dst,int weight){
            this.dst = dst;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node n){
            return this.weight>n.weight ? 1:-1;
        }
    }
    static int[] cost1;
    static int[] cost2;
    static boolean[] check;
    static List<Node>[] list;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);
        list = new ArrayList[n+1];
        cost1 = new int[n+1];
        cost2 = new int[n+1];
        check = new boolean[n+1];
        for(int i = 1;i<=n;i++)
            list[i] = new ArrayList<>();
        String[] uv = br.readLine().split(" ");
        int u = Integer.parseInt(uv[0]);
        int v = Integer.parseInt(uv[1]);
        for(int i = 0;i<m;i++){
            String []str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            list[s].add(new Node(e,w));
            list[e].add(new Node(s,w));
        }
        dijkstra(u,cost1);
        dijkstra(v,cost2);
        int max = Integer.MAX_VALUE;
        for(int i = 1;i<=n;i++){
            if(cost1[i] == Integer.MAX_VALUE)
                continue;
            for(Node node : list[i]){
                if(cost2[node.dst] == Integer.MAX_VALUE)
                    continue;
                if(max>Math.max(cost1[i],cost2[node.dst]) ){
                    max = Math.max(cost1[i],cost2[node.dst]);
                }

            }
        }
        if(max == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(max);



    }
    static void dijkstra(int start,int[]cost){
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(cost,Integer.MAX_VALUE);
        Arrays.fill(check,false);
        cost[start] = 0;

        q.offer(new Node(start,0));

        while(!q.isEmpty()){
            Node n = q.poll();
            if(check[n.dst])
                continue;
            check[n.dst] = true;
            for(Node node : list[n.dst]){
                if(cost[node.dst]> cost[n.dst]+node.weight){
                    cost[node.dst] = cost[n.dst]+node.weight;
                    q.offer(new Node(node.dst,cost[node.dst]));
                }
            }
        }
    }
}
