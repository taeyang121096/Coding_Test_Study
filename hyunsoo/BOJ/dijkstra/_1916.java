package BOJ.dijkstra;
import java.util.*;
import java.io.*;
public class _1916 {
  
  static int N,M;
  static int[][] arr;
  static int[] answer;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N=Integer.parseInt(br.readLine());
    M=Integer.parseInt(br.readLine());
    arr=new int[N+1][N+1];
    
    for(int i=0; i<N+1; i++){
      for(int j=0; j<N+1; j++){
        arr[i][j]=-1;
      }
    }


    for(int i=0; i<M; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      int x= Integer.parseInt(st.nextToken());
      int y= Integer.parseInt(st.nextToken());
      int value= Integer.parseInt(st.nextToken());
     
      if(arr[x][y]!=-1) arr[x][y]=Math.min(arr[x][y],value);
      else arr[x][y]=value;
    }

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    
    answer=new int[N+1];
    for(int i=1; i<=N; i++){
      answer[i]=Integer.MAX_VALUE;
    }
    answer[start]=0;

    bfs(start,end);
    System.out.println(answer[end]);
  }
  public static void bfs(int start, int end){
    Queue<Integer> que = new LinkedList<>();
    que.add(start);

    while(!que.isEmpty()){
      int tmp = que.poll();
      
      for(int i=1; i<=N; i++){
        if(arr[tmp][i]!=-1){
          if(answer[i]>answer[tmp]+arr[tmp][i]){
            answer[i]=answer[tmp]+arr[tmp][i];
            que.add(i);
          }
        }
      }
    }
    
    
  }
}
