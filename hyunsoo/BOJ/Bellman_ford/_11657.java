package BOJ.Bellman_ford;
import java.util.*;
import java.io.*;
public class _11657 {
    static class node implements Comparable<node>{
        int end;
        int value;
        public node(int end, int value){
            this.end = end;
            this.value=value;
        }
        public int compareTo(node n){
            return this.value - n.value;
        }
    }
    static boolean[] visit;
    static ArrayList<node>[] arr;
    static long[] value;
    static boolean check=false;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new ArrayList[N+1];
        for(int i=1; i<N+1; i++) arr[i]=new ArrayList<>();
        
        value=new long[N+1];
        Arrays.fill(value,Integer.MAX_VALUE);
        visit=new boolean[N+1];

        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine()," ");
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            int value= Integer.parseInt(st.nextToken());
            arr[x].add(new node(y,value));
        }

        bellman(1);
        StringBuilder sb = new StringBuilder();

        if(check){
            System.out.println(-1);
            return;
        }
        for(int i=2; i<=N; i++){
            if(value[i]==Integer.MAX_VALUE) sb.append(-1+"\n");
            else sb.append(value[i]+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void bellman(int start){
        
        value[start]=0;
        boolean update = false;

        for(int i=1; i<N; i++){
            update=false;
            for(int j=1; j<=N; j++){
                for(node next: arr[j]){
                    if(value[j]==Integer.MAX_VALUE){
                        break;
                    }
                    if(value[next.end]>value[j]+next.value){
                        value[next.end]=value[j]+next.value;
                        update=true;
                    }
                }
            }    
            if(!update){
                break;
            }
        }

        if(update){
            for (int i = 1; i <= N; i++) {
                for (node next : arr[i]) {
                    if(value[i]==Integer.MAX_VALUE){
                        break;
                    }

                    if (value[next.end] > value[i] + next.value) {
                        check=true;
                        return;
                    }
                }
            }
        }
    }   
}
