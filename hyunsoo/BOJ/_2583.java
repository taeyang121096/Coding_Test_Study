package BOJ;

import java.util.*;
import java.io.*;
public class _2583 {

  static int area;
  static int[] dx ={1,-1,0,0};
  static int[] dy ={0,0,1,-1};
  static int[][] arr;
  static int M;
  static int N;
  static int K;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr= new int[M][N];

    for(int i=0; i<K; i++){
      st=new StringTokenizer(br.readLine()," ");
      int lx = Integer.parseInt(st.nextToken());
      int ly = Integer.parseInt(st.nextToken());
      int rx = Integer.parseInt(st.nextToken());
      int ry = Integer.parseInt(st.nextToken());

      for(int j=lx; j<rx; j++){
        for(int l=ly; l<ry; l++){
          if(arr[l][j]==0) 
          arr[l][j]=1;
        }
      }
    }

    PriorityQueue<Integer> que = new PriorityQueue<>();
    int count=0;
    for(int i=0; i<M; i++){
      for(int j=0; j<N; j++){
        area=0;
        if(arr[i][j]==0)
         {
           count++;
           dfs(i,j);
           que.offer(area);
         }
      }
      
    } 

    System.out.println(count);
    for(int i=0; i<count; i++){
      System.out.print(que.remove()+" ");
    }
  }
  public static void dfs(int i, int j){
    arr[i][j] =1;
    area++;
    for(int m=0; m<4; m++){
      int x= i+dx[m];
      int y= j+dy[m];

      if(0<=x && x < M && 0<=y && y<N){
        if(arr[x][y]==0)
          dfs(x,y);
      }
    }
  }
}
