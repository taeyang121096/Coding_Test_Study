import java.util.*;
import java.io.*;

public class Spanning {
    static int[] parents;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        public Edge(int start,int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e){
            if(this.weight<=e.weight)
                return -1;
            else
                return 1;
        }
    }

    static int find(int x){
        if(x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int start, int end){
        int s = find(start);
        int e = find(end);
        if(s != e)
            parents[e] = s;
    }


    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parents = new int[v+1];
        for(int i = 0;i<v+1;i++)
            parents[i] = i;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            q.offer(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int sum = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Edge tmp = q.poll();
            int start = find(tmp.start);
            int end = find(tmp.end);
            if(start != end){
                sum += tmp.weight;
                union(tmp.start,tmp.end);
                cnt++;
            }
            if(cnt == v-1)
                break;

        }
        System.out.println(sum);

    }
}
