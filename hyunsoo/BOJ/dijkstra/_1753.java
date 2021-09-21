package BOJ.dijkstra;
import java.util.*;
import java.io.*;
public class _1753 {
    
    static class node implements Comparable<node>{
        int end;
        int value;
        public node(int end, int value){
            this.end=end;
            this.value=value;
        }
        public int compareTo(node n){
            return this.value-n.value;
        }
    }
    
    static int V,E,K;
    static int INF = Integer.MAX_VALUE;
    static int[] value;
    static boolean[] visit;
    static ArrayList<node>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(br.readLine());
        value=new int[V+1];
        Arrays.fill(value,INF);

        arr= new ArrayList[V+1];
        
        for(int i=1; i<=V; i++){
            arr[i]=new ArrayList<node>();
        }

        for(int i=0; i<E; i++){
            st=new StringTokenizer(br.readLine()," ");
            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            int value =Integer.parseInt(st.nextToken());

            arr[x].add(new node(y,value));
        }
        visit = new boolean[V+1];
        dij(K);
        
        StringBuilder sb =new StringBuilder();
        for(int i=1; i<=V; i++){  
            if(value[i]!=INF) sb.append(value[i]+"\n");
            else sb.append("INF"+"\n");
        }
        System.out.println(sb.toString());
    }
    public static void dij(int start){
        PriorityQueue<node> pq = new PriorityQueue<>();

        pq.add(new node(start,0));
        value[start]=0;
        
        while(!pq.isEmpty()){
            node tmp = pq.poll();
            if(visit[tmp.end]) continue;
            visit[tmp.end]=true;
            
            for(node next : arr[tmp.end]){
                if(value[next.end]>value[tmp.end]+next.value){
                    value[next.end]=value[tmp.end]+next.value;
                    pq.add(new node(next.end,value[next.end]));
                }
            }
        }
    }
}
