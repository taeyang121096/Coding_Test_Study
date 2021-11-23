package BOJ.code_plus;
import java.io.*;
import java.util.*;
public class _1260 {
  
  static int N,M,V;
  static List<Integer>[] list;
  static StringBuilder answer= new StringBuilder();
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

    dfs(V,0);
    bfs(V,0);
  }
  public static void dfs(int v, int count){
    if(count == N){
      answer.append("\n");
    }
  }

  public static void bfs(int v, int count){

  }
}
