package BOJ.basicCheck;
import java.util.*;
import java.io.*;
public class _1260 {
  
  static int[][] arr;
  static boolean[] visit;
  static boolean[] bvisit;
  static int N,M,V;
  static StringBuilder sb=new StringBuilder();
  public static void main(String[] args) throws IOException{  
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    
    N=Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());
    V=Integer.parseInt(st.nextToken());
    
    arr=new int[N+1][N+1];

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine()," ");
      int x= Integer.parseInt(st.nextToken());
      int y= Integer.parseInt(st.nextToken());

      arr[x][y]=1;
      arr[y][x]=1;
    }
    visit= new boolean[N+1];
    visit[V]=true;
    System.out.print(V+" ");
    dfs(V);
    System.out.println();
    
    
    bvisit= new boolean[N+1];
    bvisit[V]=true;
    bfs(V);

  }

  public static void dfs(int start){
    
    for(int i=1; i<=N; i++){
      if(arr[start][i]==1 && !visit[i]){
        visit[i]=true;
        System.out.print(i+" ");
        dfs(i);
      }
    }
  }

  public static void bfs(int start){
    
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    while(!q.isEmpty()){
      int tmp = q.poll();
      System.out.print(tmp+" ");
      for(int i=1; i<=N; i++){
        if(arr[tmp][i]==1 && !bvisit[i]){
          bvisit[i]=true;
          q.add(i);
        }
      }
    }
  }
}
