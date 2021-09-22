import java.util.*;
import java.io.*;
public class TimeMachine {

    static int INF = Integer.MAX_VALUE;
    static long[] dist;
    static Info[] edge;

    static class Info {
        int s;
        int e;
        int cost;

        public Info(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
    static boolean bellmanford(int start){
        for(int i = 1;i<dist.length;i++){
            for(int j = 0;j<edge.length;j++){
                Info info = edge[j];
                if(dist[info.s] != INF){
                    if(dist[info.e] > dist[info.s] + info.cost){
                        if(i == dist.length -1)
                            return false;
                        dist[info.e] = dist[info.s] + info.cost;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dist = new long[n+1];

        edge = new Info[m];
        Arrays.fill(dist,INF);

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            edge[i] = new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        dist[1] = 0;


        if(bellmanford(1)){
            for(int i = 2;i<=n;i++) {
                if(dist[i] == INF)
                    System.out.println( -1);
                else
                    System.out.println(dist[i]);
            }
        }
        else
            System.out.println( -1);
    }
}
