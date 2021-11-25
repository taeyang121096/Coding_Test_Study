package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _11724 {
  
  static boolean[] visit;
  static List<Integer>[] list;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    list = new ArrayList[N+1];
    visit= new boolean[N+1];
    for(int i=0; i<=N; i++){
      list[i] = new ArrayList<>();
    }

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine()," ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      list[u].add(v);
      list[v].add(u);
    }
    int answer=0;
    for(int i=1; i<=N; i++){
      if(!visit[i]){
        bfs(i);
        answer++;  
      }
    }  
    System.out.println(answer);  
  }
  public static void bfs(int index){
    Queue<Integer> q = new LinkedList<>();
    q.add(index);

    while(!q.isEmpty()){
      int tmp = q.poll();
      if(!visit[tmp]){
        visit[tmp]=true;
        for(int i : list[tmp]){
          if(!visit[i]){
            q.add(i);
          }
        }
      }
    }
  }
}
