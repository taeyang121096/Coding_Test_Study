package BOJ.Topological_Sort;
import java.util.*;
import java.io.*;
public class _2252 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] arr=new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            arr[b]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=1; i<=N; i++){
            if(arr[i]==0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp+"\n");
            for(int i=0; i<list[tmp].size(); i++){
                int next = list[tmp].get(i);
                arr[next]--;
                if(arr[next]==0) q.add(next);
            }
        }
        
        System.out.println(sb.toString());
    }
}
