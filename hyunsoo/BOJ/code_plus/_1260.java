package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _1260 {
  
  static int N,M,V;
  static List<Integer>[] list;
  //static StringBuilder answer= new StringBuilder();
  static boolean[] visit;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());
    list = new ArrayList[N+1];
    for(int i=1; i<=N; i++){
      list[i] = new ArrayList<>();
    }
    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine()," ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[x].add(y);
      list[y].add(x);
    }

    visit = new boolean[N+1];
    visit[V]=true;
    dfs(V,1);
    System.out.println();
    visit= new boolean[N+1];
    bfs(V);

    //System.out.print(answer.toString());
  }
  public static void dfs(int v, int count){
    
    //answer.append(v+" ");
    System.out.print(v+" ");

    if(count == N){
      //answer.append("\n");
      return;
    }
    
    for(int i=1; i<=N; i++){
      if(list[v].contains(i) && !visit[i]){
        visit[i]=true;    
        dfs(i, count+1);
      }
    }
  }

  public static void bfs(int v){
    Queue<Integer> q = new LinkedList<>();
    q.add(v);

    while(!q.isEmpty()){
      int tmp = q.poll();
      visit[tmp]=true;
      System.out.print(tmp+" ");
      //answer.append(tmp+" ");
      for(int i=1; i<=N; i++){
        if(list[tmp].contains(i) && !visit[i]){
          visit[i]=true;
          q.add(i);
        }
      }
    }
  }
}
